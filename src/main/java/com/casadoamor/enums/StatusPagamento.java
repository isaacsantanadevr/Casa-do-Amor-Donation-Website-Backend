/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: StatusPagamento.java
* Funcao...........: Enum para status de pagamento
*************************************************************** */
package com.casadoamor.enums;

/* ***************************************************************
* Enum: StatusPagamento
* Funcao: Define os status de pagamento disponiveis.
* Valores:
*   - PENDENTE: Pagamento pendente.
*   - PAGO: Pagamento realizado com sucesso.
*   - FALHA: Pagamento falhou.
*   - EXPIRADO: Pagamento expirado.
*************************************************************** */
public enum StatusPagamento {
  PENDENTE,
  PAGO,
  FALHA,
  EXPIRADO
}