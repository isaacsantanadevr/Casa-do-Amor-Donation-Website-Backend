/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: StatusDoacao.java
* Funcao...........: Enumeracao que define os possiveis status de uma doacao
*************************************************************** */
package com.casadoamor.doacao.enums;

/* ***************************************************************
* Enum: StatusDoacao
* Funcao: Define o status de uma doacao.
* Valores:
*   - PENDING: Doacao pendente de processamento
*   - REQUIRES_ACTION:  Doacao requer acao adicional do usuario
*   - PAID: Doacao paga com sucesso
*   - FAILED: Doacao falhou no processamento
*   - CANCELLED: Doacao cancelada
*************************************************************** */
public enum StatusDoacao {
  PENDING, 
  REQUIRES_ACTION,
  PAID,
  FAILED,
  CANCELLED
}