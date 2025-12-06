/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: CriarDoacaoRequest.java
* Funcao...........: DTO para receber dados da requisicao de criacao de doacao
*************************************************************** */
package com.casadoamor.doacao.dto;

import java.math.BigDecimal;

public class CriarDoacaoRequest {
  private BigDecimal valor; // Valor monetario da doacao
  private String descricao; // Descricao opcional da doacao

  private String metodoPagamento;  // Metodo de pagamento escolhido (ex: cartao, pix, boleto)

  private String nomeDoador; // Nome completo do doador
  private String emailDoador; // Email do doador para confirmacao e contato

  // Atributos para pagamento com cartao
  private String tokenCartao; // token gerado no front pelo gateway
  private Integer parcelas; // Quantidade de parcelas
  private String metodoPagamentoId; // Ex: visa, master, elo (Bandeira do cartao)
  private String tipoPagamento; // credit_card ou debit_card
  private String documentoTipo; // Ex: CPF
  private String documentoNumero; // Numero do documento
  /* ***************************************************************
  * Construtor: CriarDoacaoRequest
  * Funcao: Construtor padrao da classe.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public CriarDoacaoRequest() {}
  /* ***************************************************************
  * Metodo: getValor
  * Funcao: Retorna o valor da doacao.
  * Parametros: Sem parametros.
  * Retorno: BigDecimal - Valor da doacao.
  *************************************************************** */
  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
  /* ***************************************************************
  * Metodo: getDescricao
  * Funcao: Retorna a descricao da doacao
  * Parametros: Sem parametros.
  * Retorno: String - Descricao da doacao.
  *************************************************************** */
  public String getDescricao() {
    return descricao;
  }
  /* ***************************************************************
  * Metodo: setDescricao
  * Funcao: Define a descricao da doacao.
  * Parametros: descricao - Descricao da doacao.
  * Retorno: void
  *************************************************************** */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  /* ***************************************************************
  * Metodo: getMetodoPagamento
  * Funcao: Retorna o metodo de pagamento escolhido.
  * Parametros: Sem parametros.
  * Retorno: String - Metodo de pagamento.
  *************************************************************** */
  public String getMetodoPagamento() {
    return metodoPagamento;
  }
  /* ***************************************************************
  * Metodo: setMetodoPagamento
  * Funcao: Define o metodo de pagamento.
  * Parametros: metodoPagamento - Metodo de pagamento.
  * Retorno: void
  *************************************************************** */
  public void setMetodoPagamento(String metodoPagamento) {
    this.metodoPagamento = metodoPagamento;
  }
  /* ***************************************************************
  * Metodo: getNomeDoador
  * Funcao: Retorna o nome do doador.
  * Parametros: Sem parametros.
  * Retorno: String - Nome do doador.
  *************************************************************** */
  public String getNomeDoador() {
    return nomeDoador;
  }
  /* ***************************************************************
  * Metodo: setNomeDoador
  * Funcao: Define o nome do doador.
  * Parametros: nomeDoador - Nome do doador.
  * Retorno: void
  *************************************************************** */
  public void setNomeDoador(String nomeDoador) {
    this.nomeDoador = nomeDoador;
  }
  /* ***************************************************************
  * Metodo: getEmailDoador
  * Funcao: Retorna o email do doador.
  * Parametros: Sem parametros.
  * Retorno: String - Email do doador.
  *************************************************************** */
  public String getEmailDoador() {
    return emailDoador;
  }
  /* ***************************************************************
  * Metodo: setEmailDoador
  * Funcao: Define o email do doador.
  * Parametros: emailDoador - Email do doador.
  * Retorno: void
  *************************************************************** */
  public void setEmailDoador(String emailDoador) {
    this.emailDoador = emailDoador;
  }
  /* ***************************************************************
  * Metodo: getTokenCartao
  * Funcao: Retorna o token do cartao gerado pelo gateway.
  * Parametros: Sem parametros.
  * Retorno: String - Token do cartao.
  *************************************************************** */
  public String getTokenCartao() {
    return tokenCartao;
  }
  /* ***************************************************************
  * Metodo: setTokenCartao
  * Funcao: Define o token do cartao.
  * Parametros: tokenCartao - Token do cartao.
  * Retorno: void
  *************************************************************** */
  public void setTokenCartao(String tokenCartao) {
    this.tokenCartao = tokenCartao;
  }
  /* ***************************************************************
  * Metodo: getParcelas
  * Funcao: Retorna a quantidade de parcelas.
  * Parametros: Sem parametros.
  * Retorno: Integer - Quantidade de parcelas.
  *************************************************************** */
  public Integer getParcelas() {
    return parcelas;
  }
  /* ***************************************************************
  * Metodo: setParcelas
  * Funcao: Define a quantidade de parcelas.
  * Parametros: parcelas - Quantidade de parcelas.
  * Retorno: void
  *************************************************************** */
  public void setParcelas(Integer parcelas) {
    this.parcelas = parcelas;
  }
  /* ***************************************************************
  * Metodo: getMetodoPagamentoId
  * Funcao: Retorna a bandeira do cartao.
  * Parametros: Sem parametros.
  * Retorno: String - Bandeira do cartao.
  *************************************************************** */
  public String getMetodoPagamentoId() {
    return metodoPagamentoId;
  }
  /* ***************************************************************
  * Metodo: setMetodoPagamentoId
  * Funcao: Define a bandeira do cartao.
  * Parametros: metodoPagamentoId - Bandeira do cartao.
  * Retorno: void
  *************************************************************** */
  public void setMetodoPagamentoId(String metodoPagamentoId) {
    this.metodoPagamentoId = metodoPagamentoId;
  }
  /* ***************************************************************
  * Metodo: getTipoPagamento
  * Funcao: Retorna o tipo do cartao (credito/debito).
  * Parametros: Sem parametros.
  * Retorno: String - Tipo do cartao.
  *************************************************************** */
  public String getTipoPagamento() {
    return tipoPagamento;
  }
  /* ***************************************************************
  * Metodo: setTipoPagamento
  * Funcao: Define o tipo do cartao.
  * Parametros: tipoPagamento - Tipo do cartao.
  * Retorno: void
  *************************************************************** */
  public void setTipoPagamento(String tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }
  /* ***************************************************************
  * Metodo: getDocumentoTipo
  * Funcao: Retorna o tipo do documento do pagador.
  * Parametros: Sem parametros.
  * Retorno: String - Tipo do documento.
  *************************************************************** */
  public String getDocumentoTipo() {
    return documentoTipo;
  }
  /* ***************************************************************
  * Metodo: setDocumentoTipo
  * Funcao: Define o tipo do documento do pagador.
  * Parametros: documentoTipo - Tipo do documento.
  * Retorno: void
  *************************************************************** */
  public void setDocumentoTipo(String documentoTipo) {
    this.documentoTipo = documentoTipo;
  }
  /* ***************************************************************
  * Metodo: getDocumentoNumero
  * Funcao: Retorna o numero do documento do pagador.
  * Parametros: Sem parametros.
  * Retorno: String - Numero do documento.
  *************************************************************** */
  public String getDocumentoNumero() {
    return documentoNumero;
  }
  /* ***************************************************************
  * Metodo: setDocumentoNumero
  * Funcao: Define o numero do documento do pagador.
  * Parametros: documentoNumero - Numero do documento.
  * Retorno: void
  *************************************************************** */
  public void setDocumentoNumero(String documentoNumero) {
    this.documentoNumero = documentoNumero;
  }
}