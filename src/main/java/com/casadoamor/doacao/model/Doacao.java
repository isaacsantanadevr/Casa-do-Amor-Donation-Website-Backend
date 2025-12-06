/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: Doacao.java
* Funcao...........: Classe de modelo que representa uma doacao no sistema
*************************************************************** */
package com.casadoamor.doacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.casadoamor.doacao.enums.StatusDoacao;

public class Doacao {
  private Long id; // ID unico da doacao no banco de dados
  
  private BigDecimal valor; // Valor monetario da doacao
  private String moeda; // Tipo de moeda (ex: BRL, USD)
  
  private StatusDoacao statusDoacao; // Status atual da doacao
  
  private String referenciaExt; // ID externo enviado ao gateway de pagamento para rastreamento
  private String pagamentoId; // ID retornado pelo gateway de pagamento
  private String idempotencyKey; // Chave para evitar duplicidade de transacoes
  
  private String nomeDoador; // Nome do doador
  private String emailDoador; // Email do doador
  
  private LocalDateTime criadoEm; // Data e hora de criacao da doacao
  private LocalDateTime atualizadoEm; // Data e hora da ultima atualizacao
  /* ***************************************************************
  * Construtor: Doacao
  * Funcao: Construtor padrao da classe.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public Doacao() {}
  /* ***************************************************************
  * Metodo: getId
  * Funcao: Retorna o ID da doacao.
  * Parametros: Sem parametros.
  * Retorno: Long - ID da doacao.
  *************************************************************** */
  public Long getId() {
    return id;
  }
  /* ***************************************************************
  * Metodo: setId
  * Funcao: Define o ID da doacao.
  * Parametros: id - ID da doacao.
  * Retorno: void
  *************************************************************** */
  public void setId(Long id) {
    this.id = id;
  }
  /* ***************************************************************
  * Metodo: getValor
  * Funcao: Retorna o valor da doacao.
  * Parametros: Sem parametros.
  * Retorno: BigDecimal - Valor da doacao.
  *************************************************************** */
  public BigDecimal getValor() {
    return valor;
  }
  /* ***************************************************************
  * Metodo: setValor
  * Funcao: Define o valor da doacao.
  * Parametros: valor - Valor da doacao.
  * Retorno: void
  *************************************************************** */
  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
  /* ***************************************************************
  * Metodo: getMoeda
  * Funcao: Retorna o tipo de moeda da doacao.
  * Parametros: Sem parametros.
  * Retorno: String - Tipo de moeda.
  *************************************************************** */
  public String getMoeda() {
    return moeda;
  }
  /* ***************************************************************
  * Metodo: setMoeda
  * Funcao: Define o tipo de moeda da doacao.
  * Parametros: moeda - Tipo de moeda.
  * Retorno: void
  *************************************************************** */
  public void setMoeda(String moeda) {
    this.moeda = moeda;
  }
  /* ***************************************************************
  * Metodo: getStatusDoacao
  * Funcao: Retorna o status da doacao.
  * Parametros: Sem parametros.
  * Retorno: StatusDoacao - Status da doacao.
  *************************************************************** */
  public StatusDoacao getStatusDoacao() {
    return statusDoacao;
  }
  /* ***************************************************************
  * Metodo: setStatusDoacao
  * Funcao: Define o status da doacao.
  * Parametros: statusDoacao - Status da doacao.
  * Retorno: void
  *************************************************************** */
  public void setStatusDoacao(StatusDoacao statusDoacao) {
    this.statusDoacao = statusDoacao;
  }
  /* ***************************************************************
  * Metodo: getReferenciaExt
  * Funcao: Retorna a referencia externa da doacao.
  * Parametros: Sem parametros.
  * Retorno: String - Referencia externa.
  *************************************************************** */
  public String getReferenciaExt() {
    return referenciaExt;
  }
  /* ***************************************************************
  * Metodo: setReferenciaExt
  * Funcao: Define a referencia externa da doacao.
  * Parametros: referenciaExt - Referencia externa.
  * Retorno: void
  *************************************************************** */
  public void setReferenciaExt(String referenciaExt) {
    this.referenciaExt = referenciaExt;
  }
  /* ***************************************************************
  * Metodo: getPagamentoId
  * Funcao: Retorna o ID do pagamento no gateway.
  * Parametros: Sem parametros.
  * Retorno: String - ID do pagamento.
  *************************************************************** */
  public String getPagamentoId() {
    return pagamentoId;
  }
  /* ***************************************************************
  * Metodo: setPagamentoId
  * Funcao: Define o ID do pagamento no gateway.
  * Parametros: pagamentoId - ID do pagamento.
  * Retorno: void
  *************************************************************** */
  public void setPagamentoId(String pagamentoId) {
    this.pagamentoId = pagamentoId;
  }
  /* ***************************************************************
  * Metodo: getIdempotencyKey
  * Funcao: Retorna a chave de idempotencia da transacao.
  * Parametros: Sem parametros.
  * Retorno: String - Chave de idempotencia.
  *************************************************************** */
  public String getIdempotencyKey() {
    return idempotencyKey;
  }
  /* ***************************************************************
  * Metodo: setIdempotencyKey
  * Funcao: Define a chave de idempotencia da transacao.
  * Parametros: idempotencyKey - Chave de idempotencia.
  * Retorno: void
  *************************************************************** */
  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
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
  * Funcao: Retorna o email do doador
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
  * Metodo: getCriadoEm
  * Funcao: Retorna a data e hora de criacao da doacao.
  * Parametros: Sem parametros.
  * Retorno: LocalDateTime - Data e hora de criacao.
  *************************************************************** */
  public LocalDateTime getCriadoEm() {
    return criadoEm;
  }
  /* ***************************************************************
  * Metodo: setCriadoEm
  * Funcao: Define a data e hora de criacao da doacao.
  * Parametros: criadoEm - Data e hora de criacao.
  * Retorno: void
  *************************************************************** */
  public void setCriadoEm(LocalDateTime criadoEm) {
    this.criadoEm = criadoEm;
  }
  /* ***************************************************************
  * Metodo: getAtualizadoEm
  * Funcao: Retorna a data e hora da ultima atualizacao da doacao.
  * Parametros: Sem parametros.
  * Retorno: LocalDateTime - Data e hora da ultima atualizacao.
  *************************************************************** */
  public LocalDateTime getAtualizadoEm() {
    return atualizadoEm;
  }
  /* ***************************************************************
  * Metodo: setAtualizadoEm
  * Funcao: Define a data e hora da ultima atualizacao da doacao.
  * Parametros: atualizadoEm - Data e hora da ultima atualizacao.
  * Retorno: void
  *************************************************************** */
  public void setAtualizadoEm(LocalDateTime atualizadoEm) {
    this.atualizadoEm = atualizadoEm;
  }
}