/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: CriarDoacaoResponse.java
* Funcao...........: DTO para retornar dados da resposta de criacao de doacao
*************************************************************** */
package com.casadoamor.doacao.dto;

public class CriarDoacaoResponse {
  private Long id; // ID interno da doacao gerado no banco de dados
  private String status; // Status atual da doacao (PENDING, APPROVED, REJECTED, etc.)
  private String metodoPagamento; // Metodo de pagamento utilizado na transacao
  
  // Atributos especificos para pagamento via PIX
  private String qrCode; // String/texto do codigo QR para pagamento PIX
  private String qrCodeImg; // Imagem do codigo QR em formato base64 ou URL
  
  // Atributos especificos para pagamento via cartao
  private String pagamentoId; // ID do pagamento gerado pelo gateway externo
  private String mensagem; // Mensagem de resposta do gateway de pagamento
  /* ***************************************************************
  * Metodo: CriarDoacaoResponse
  * Funcao: Construtor padrao da classe.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public CriarDoacaoResponse() {}
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
  * Metodo: getStatus
  * Funcao: Retorna o status da doacao.
  * Parametros: Sem parametros.
  * Retorno: String - Status da doacao.
  *************************************************************** */
  public String getStatus() {
    return status;
  }
  /* ***************************************************************
  * Metodo: setStatus
  * Funcao: Define o status da doacao.
  * Parametros: status - Status da doacao.
  * Retorno: void
  *************************************************************** */
  public void setStatus(String status) {
    this.status = status;
  }
  /* ***************************************************************
  * Metodo: getMetodoPagamento
  * Funcao: Retorna o metodo de pagamento utilizado.
  * Parametros: Sem parametros.
  * Retorno: String - Metodo de pagamento.
  *************************************************************** */
  public String getMetodoPagamento() {
    return metodoPagamento;
  }
  /* ***************************************************************
  * Metodo: setMetodoPagamento
  * Funcao: Define o metodo de pagamento utilizado.
  * Parametros: metodoPagamento - Metodo de pagamento.
  * Retorno: void
  *************************************************************** */
  public void setMetodoPagamento(String metodoPagamento) {
    this.metodoPagamento = metodoPagamento;
  }
  /* **************************************************************
  * Metodo: getQrCode
  * Funcao: Retorna o codigo QR em formato texto.
  * Parametros: Sem parametros.
  * Retorno: String - Codigo QR.
  *************************************************************** */
  public String getQrCode() {
    return qrCode;
  }
  /* ***************************************************************
  * Metodo: setQrCode
  * Funcao: Define o codigo QR em formato texto.
  * Parametros: qrCode - Codigo QR.
  * Retorno: void
  *************************************************************** */
  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }
  /* ***************************************************************
  * Metodo: getQrCodeImg
  * Funcao: Retorna a imagem do codigo QR.
  * Parametros: Sem parametros.
  * Retorno: String - Imagem do codigo QR.
  *************************************************************** */
  public String getQrCodeImg() {
    return qrCodeImg;
  }
  /* ***************************************************************
  * Metodo: setQrCodeImg
  * Funcao: Define a imagem do codigo QR.
  * Parametros: qrCodeImg - Imagem do codigo QR.
  * Retorno: void
  *************************************************************** */
  public void setQrCodeImg(String qrCodeImg) {
    this.qrCodeImg = qrCodeImg;
  }
  /* ***************************************************************
  * Metodo: getPagamentoId
  * Funcao: Retorna o ID do pagamento gerado pelo gateway.
  * Parametros: Sem parametros.
  * Retorno: String - ID do pagamento.
  *************************************************************** */
  public String getPagamentoId() {
    return pagamentoId;
  }
  /* ***************************************************************
  * Metodo: setPagamentoId
  * Funcao: Define o ID do pagamento gerado pelo gateway.
  * Parametros: pagamentoId - ID do pagamento.
  * Retorno: void
  *************************************************************** */
  public void setPagamentoId(String pagamentoId) {
    this.pagamentoId = pagamentoId;
  }
  /* ***************************************************************
  * Metodo: getMensagem
  * Funcao: Retorna a mensagem de resposta do gateway.
  * Parametros: Sem parametros.
  * Retorno: String - Mensagem do gateway.
  *************************************************************** */
  public String getMensagem() {
    return mensagem;
  }
  /* ***************************************************************
  * Metodo: setMensagem
  * Funcao: Define a mensagem de resposta do gateway.
  * Parametros: mensagem - Mensagem do gateway.
  * Retorno: void
  *************************************************************** */
  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
}