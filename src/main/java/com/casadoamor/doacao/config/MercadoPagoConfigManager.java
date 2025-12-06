/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: MercadoPagoConfigManager.java
* Funcao...........: Classe responsavel por gerenciar as configuracoes do Mercado Pago
*************************************************************** */
package com.casadoamor.doacao.config;

import com.mercadopago.MercadoPagoConfig;

public class MercadoPagoConfigManager{
  private static MercadoPagoProp propriedades; // Propriedades do Mercado Pago
  /* *******************************************************
  * Metodo.........: configuracoes
  * Funcao.........: Configura as propriedades do Mercado Pago
  * Parametros.....: MercadoPagoProp prop - Propriedades do Mercado Pago
  * Retorno........: void
  * ******************************************************* */
  public static void configuracoes(MercadoPagoProp prop){
    propriedades = prop;
    MercadoPagoConfig.setAccessToken(propriedades.getAccessToken());
  }
  /* *******************************************************
  * Metodo.........: getPropriedades
  * Funcao.........: Retorna as propriedades do Mercado Pago
  * Parametros.....: void
  * Retorno........: MercadoPagoProp - Propriedades do Mercado Pago
  * ******************************************************* */
  public static MercadoPagoProp getPropriedades() {
    return propriedades;
  }
}