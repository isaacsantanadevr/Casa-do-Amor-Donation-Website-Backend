/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: PagamentoResultado.java
* Funcao...........: Classe para representar o resultado de uma operacao de pagamento
*************************************************************** */
package com.casadoamor.doacao.gateway;

public class PagamentoResultado {
  private String pagamentoId; // ID do pagamento no gateway externo
  private String qrCode; // Codigo QR para pagamento PIX (texto)
  private String qrCodeImg; // Imagem do codigo QR PIX (base64)
  private String mensagem; // Mensagem descritiva do resultado
  private String referenciaExt; // Referencia externa associada ao pagamento
  private String status; // Status do pagamento (approved, pending, rejected, etc.)
  /* ***************************************************************
  * Construtor: PagamentoResultado
  * Funcao: Construtor padrao da classe.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public PagamentoResultado() {}
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
  * Metodo: getReferenciaExt
  * Funcao: Retorna a referencia externa do pagamento.
  * arametros: Sem parametros.
  * Retorno: String - Referencia externa.
  *************************************************************** */
  public String getReferenciaExt() {
    return referenciaExt;
  }
  /* ***************************************************************
  * Metodo: setReferenciaExt
  * Funcao: Define a referencia externa do pagamento.
  * Parametros: referenciaExt - Referencia externa.
  * Retorno: void
  *************************************************************** */
  public void setReferenciaExt(String referenciaExt) {
    this.referenciaExt = referenciaExt;
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
  * Metodo: getMensagem
  * Funcao: Retorna a mensagem descritiva do resultado.
  * Parametros: Sem parametros.
  * Retorno: String - Mensagem do resultado.
  *************************************************************** */
  public String getMensagem() {
    return mensagem;
  }
  /* ***************************************************************
  * Metodo: setMensagem
  * Funcao: Define a mensagem descritiva do resultado.
  * Parametros: mensagem - Mensagem do resultado.
  * Retorno: void
  *************************************************************** */
  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
  /* ***************************************************************
  * Metodo: getStatus
  * Funcao: Retorna o status do pagamento.
  * Parametros: Sem parametros.
  * Retorno: String - Status do pagamento.
  *************************************************************** */
  public String getStatus() {
    return status;
  }
  /* ***************************************************************
  * Metodo: setStatus
  * Funcao: Define o status do pagamento.
  * Parametros: status - Status do pagamento.
  * Retorno: void
  *************************************************************** */
  public void setStatus(String status) {
    this.status = status;
  }
}