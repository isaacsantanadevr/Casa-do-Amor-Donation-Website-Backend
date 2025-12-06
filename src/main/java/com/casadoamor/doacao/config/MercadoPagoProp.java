/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: MercadoPagoProp.java
* Funcao...........: Classe responsavel por armazenar as propriedades do Mercado Pago
*************************************************************** */
package com.casadoamor.doacao.config;

public class MercadoPagoProp {
  private String accessToken; // Token de acesso do Mercado Pago
  private String webhook;     // URL do webhook do Mercado Pago
  /* *******************************************************
  * Construtor.....: MercadoPagoProp
  * Funcao.........: Construtor da classe MercadoPagoProp
  * Parametros.....: void
  * Retorno........: void
  * ******************************************************* */
  public MercadoPagoProp() {}
  /* *******************************************************
  * Metodo.........: getAccessToken
  * Funcao.........: Retorna o token de acesso do Mercado Pago
  * Parametros.....: void
  * Retorno........: String - Token de acesso do Mercado Pago
  * ******************************************************* */
  public String getAccessToken() {
    return accessToken;
  }
  /* *******************************************************
  * Metodo.........: setAccessToken
  * Funcao.........: Define o token de acesso do Mercado Pago
  * Parametros.....: String accessToken - Token de acesso do Mercado Pago
  * Retorno........: void
  * ******************************************************* */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
  /* *******************************************************
  * Metodo.........: getWebhook
  * Funcao.........: Retorna a URL do webhook do Mercado Pago
  * Parametros.....: void
  * Retorno........: String - URL do webhook do Mercado Pago
  * ******************************************************* */
  public String getWebhook() {
    return webhook;
  }
  /* *******************************************************
  * Metodo.........: setWebhook
  * Funcao.........: Define a URL do webhook do Mercado Pago
  * Parametros.....: String webhook - URL do webhook do Mercado Pago
  * Retorno........: void
  * ******************************************************* */
  public void setWebhook(String webhook) {
    this.webhook = webhook;
  }
}