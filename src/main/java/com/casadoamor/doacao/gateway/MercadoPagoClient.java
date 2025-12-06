/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: MercadoPagoClient.java
* Funcao...........: Cliente para integracao com a API do Mercado Pago
*************************************************************** */
package com.casadoamor.doacao.gateway;

import java.util.Map;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.casadoamor.doacao.config.MercadoPagoConfigManager;
import com.casadoamor.doacao.dto.CriarDoacaoRequest;
import com.casadoamor.doacao.model.Doacao;

public class MercadoPagoClient {
  private final WebClient webClient;
  /* ***************************************************************
  * Metodo: MercadoPagoClient
  * Funcao: Construtor que inicializa o cliente WebClient com as configuracoes do Mercado Pago.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public MercadoPagoClient() {
    // Obtem configuracoes do Mercado Pago
    var prop = MercadoPagoConfigManager.getPropriedades();
    if (prop == null) {
      prop = new com.casadoamor.doacao.config.MercadoPagoProp();
      prop.setAccessToken(System.getenv("ACCESS_TOKEN"));
      prop.setWebhook(System.getenv("WEBHOOK_SECRET"));
      MercadoPagoConfigManager.configuracoes(prop);
    }

    String accessToken = prop.getAccessToken();
    if (accessToken == null || accessToken.isBlank()) {
      // Tenta pegar direto do ambiente caso a classe de config tenha falhado
      accessToken = System.getenv("ACCESS_TOKEN");
      if (accessToken == null || accessToken.isBlank()) {
          throw new IllegalStateException("Access token do Mercado Pago nao configurado");
      }
    }
    MercadoPagoConfigManager.configuracoes(prop);
    // Cria o WebClient com a URL base e cabecalho de autorizacao
    this.webClient = WebClient.builder().baseUrl("https://api.mercadopago.com").defaultHeader("Authorization", "Bearer " + accessToken).build();
  }
  /* ***************************************************************
  * Metodo: criarPagamentoPix
  * Funcao: Cria um pagamento via PIX no Mercado Pago.
  * Parametros: doacao - Objeto Doacao com dados da doacao.
                request - Objeto CriarDoacaoRequest com dados da requisicao.
  * Retorno: PagamentoResultado - Resultado da operacao de pagamento.
  *************************************************************** */
  public PagamentoResultado criarPagamentoPix(Doacao doacao, CriarDoacaoRequest request) {
    String descricao = request.getDescricao() != null ? request.getDescricao() : "Doacao para Casa do Amor";

    // Monta o corpo da requisicao para o PIX
    var body = Map.of(
            "transaction_amount", doacao.getValor(),
            "description", descricao,
            "payment_method_id", "pix",
            "external_reference", doacao.getReferenciaExt(),
            "notification_url", "https://seu-dominio.com/notifications",
            "payer", Map.of(
                     "email", doacao.getEmailDoador()
                    )
    );

    try {
      // Envia requisicao para API do Mercado Pago
      Map<String, Object> response = this.webClient.post()
                                    .uri("/v1/payments")
                                    .header("X-Idempotency-Key", doacao.getIdempotencyKey())
                                    .bodyValue(body)
                                    .retrieve()
                                    .bodyToMono(Map.class)
                                    .block();

      if (response == null) {
        throw new RuntimeException("Resposta vazia do Mercado Pago");
      }

      // Extrai dados do PIX da resposta
      Map<String, Object> pointOfInteraction = (Map<String, Object>) response.get("point_of_interaction");
      Map<String, Object> trans = pointOfInteraction != null ? (Map<String, Object>) pointOfInteraction.get("transaction_data") : null;

      PagamentoResultado resultado = new PagamentoResultado();
      resultado.setPagamentoId(asString(response.get("id")));
      resultado.setReferenciaExt(asString(response.get("external_reference")));
      resultado.setStatus(asString(response.get("status")));
      
      // Se houver dados de transacao PIX, extrai QR Code
      if (trans != null) {
        resultado.setQrCode(asString(trans.get("qr_code")));
        resultado.setQrCodeImg(asString(trans.get("qr_code_base64")));
      }
      resultado.setMensagem("Pix criado com sucesso");

      return resultado;

    } catch (WebClientResponseException e) {
      String erroMsg = e.getResponseBodyAsString();
      System.err.println("Erro MP Pix: " + erroMsg);
      throw new RuntimeException("Erro ao criar Pix: " + e.getStatusCode());
    }
  }
  /* ***************************************************************
  * Metodo: criarPagamentoCartao
  * Funcao: Cria um pagamento via cartao de credito/debito no Mercado Pago.
  * Parametros: doacao - Objeto Doacao com dados da doacao.
                request - Objeto CriarDoacaoRequest com dados da requisicao.
  * Retorno: PagamentoResultado - Resultado da operacao de pagamento.
  *************************************************************** */
  public PagamentoResultado criarPagamentoCartao(Doacao doacao, CriarDoacaoRequest request) {
    // Valida dados obrigatorios para cartao
    if (request.getTokenCartao() == null || request.getTokenCartao().isEmpty()) {
      throw new IllegalArgumentException("Token do cartao obrigatorio");
    }
    if (request.getMetodoPagamentoId() == null || request.getMetodoPagamentoId().isEmpty()) {
      throw new IllegalArgumentException("ID do metodo de pagamento (bandeira ex: master) obrigatorio");
    }
    if (request.getDocumentoNumero() == null || request.getDocumentoNumero().isEmpty()) {
      throw new IllegalArgumentException("Numero do documento (CPF/CNPJ) obrigatorio");
    }

    String descricao = request.getDescricao() != null ? request.getDescricao() : "Doacao para Casa do Amor";
    String tipoPagamento = request.getTipoPagamento() != null ? request.getTipoPagamento() : "credit_card";
    String documentoTipo = request.getDocumentoTipo() != null ? request.getDocumentoTipo() : "CPF";

    // Define parcelas (debito sempre 1 parcela)
    Integer parcelas = request.getParcelas() != null ? request.getParcelas() : 1;
    if ("debit_card".equalsIgnoreCase(tipoPagamento)) {
      parcelas = 1;
    }

    // Monta corpo da requisicao para pagamento com cartao
    var body = Map.of(
            "transaction_amount", doacao.getValor(),
            "description", descricao,
            "token", request.getTokenCartao(),
            "installments", parcelas,
            "payment_method_id", request.getMetodoPagamentoId(),
            "external_reference", doacao.getReferenciaExt(),
            "notification_url", "https://seu-dominio.com/notifications",
            "payer", Map.of(
                    "email", doacao.getEmailDoador(),
                    "identification", Map.of(
                            "type", documentoTipo,
                            "number", request.getDocumentoNumero()
                            )
                    )
    );

    try {
      // Envia requisicao para API do Mercado Pago
      Map<String, Object> response = this.webClient.post()
                          .uri("/v1/payments")
                          .header("X-Idempotency-Key", doacao.getIdempotencyKey())
                          .bodyValue(body)
                          .retrieve().bodyToMono(Map.class).block();

      if (response == null) {
        throw new RuntimeException("Resposta vazia do Mercado Pago");
      }

      // Processa resposta do pagamento com cartao
      PagamentoResultado resultado = new PagamentoResultado();
      resultado.setPagamentoId(asString(response.get("id")));
      resultado.setReferenciaExt(asString(response.get("external_reference")));

      String status = asString(response.get("status"));
      String statusDetail = asString(response.get("status_detail"));

      resultado.setStatus(status);
      resultado.setMensagem("Pagamento processado: " + status + " (" + statusDetail + ")");
      return resultado;

    } catch (WebClientResponseException e) {
      String erroMsg = e.getResponseBodyAsString();
      System.err.println("Erro ao criar pagamento cartao: " + erroMsg);
      throw new RuntimeException("Erro Mercado Pago: " + e.getStatusCode() + " - " + erroMsg);
    }
  }
  /* ***************************************************************
  * Metodo: consultarPagamento
  * Funcao: Consulta o status de um pagamento no Mercado Pago pelo ID.
  * Parametros: pagamentoId - ID do pagamento no Mercado Pago.
  * Retorno: PagamentoResultado - Resultado da consulta com status atual.
  *************************************************************** */
  public PagamentoResultado consultarPagamento(String pagamentoId) {
    try {
      // Consulta pagamento na API do Mercado Pago
      Map<String, Object> response = this.webClient.get()
                          .uri("/v1/payments/{id}", pagamentoId)
                          .retrieve()
                          .bodyToMono(Map.class)
                          .block();

      if (response == null) {
        throw new RuntimeException("Resposta vazia do Mercado Pago");
      }

      // Extrai dados da resposta
      PagamentoResultado resultado = new PagamentoResultado();
      resultado.setPagamentoId(asString(response.get("id")));
      resultado.setReferenciaExt(asString(response.get("external_reference")));
      resultado.setStatus(asString(response.get("status")));
      return resultado;
    } catch (WebClientResponseException e) {
        throw new RuntimeException("Erro ao consultar: " + e.getStatusCode());
    }
  }
  /* ***************************************************************
  * Metodo: asString
  * Funcao: Converte um objeto para String de forma segura.
  * Parametros: value - Objeto a ser convertido.
  * Retorno: String - Representacao em string do objeto ou null.
  *************************************************************** */
  private String asString(Object value) {
    return value != null ? value.toString() : null;
  }
}