/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: MetodoPagamento.java
* Funcao...........: Enum para metodos de pagamento
*************************************************************** */
package com.casadoamor.enums;

/* ***************************************************************
* Enum: MetodoPagamento
* Funcao: Define os metodos de pagamento disponiveis.
* Valores:
*   - PIX: Pagamento via PIX.
*   - BOLETO: Pagamento via boleto bancario.
*   - CARTAO_CREDITO: Pagamento via cartao de credito.
*************************************************************** */
public enum MetodoPagamento {
  PIX,
  BOLETO,
  CARTAO_CREDITO
}