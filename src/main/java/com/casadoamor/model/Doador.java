/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: Doador.java
* Funcao...........: Classe modelo que representa um doador no sistema.
*************************************************************** */
package com.casadoamor.model;

import java.time.LocalDate;

public class Doador extends Usuario {
  private LocalDate dataCadastro; // Data em que o doador se cadastrou no sistema
  /* ***************************************************************
  * Construtor: Doador
  * Funcao: Inicializa um novo objeto Doador
  * Parametros: Sem parametros.
  * Retorno: void
  * *************************************************************** */
  public Doador() {
    super();
  }
  /* ***************************************************************
  * Construtor: Doador
  * Funcao: Inicializa um novo objeto Doador com os parametros fornecidos
  * Parametros: idUsuario - ID unico do doador
                nome - Nome do doador
                email - Email do doador
                cpf - CPF do doador
                telefone - Telefone do doador
                dataCadastro - Data em que o doador se cadastrou no sistema
  * Retorno: void
  * *************************************************************** */
  public Doador(long idUsuario, String nome, String email, String cpf, String telefone, LocalDate dataCadastro) {
    super(idUsuario, nome, email, cpf, telefone);
    this.dataCadastro = dataCadastro;
  }
  /* ***************************************************************
  * Metodo: getDataCadastro
  * Funcao: Retorna a data em que o doador se cadastrou no sistema
  * Parametros: Sem parametros.
  * Retorno: LocalDate - Data em que o doador se cadastrou no sistema
  * *************************************************************** */
  public LocalDate getDataCadastro() {
    return dataCadastro;
  }
  /* ***************************************************************
  * Metodo: setDataCadastro
  * Funcao: Define a data em que o doador se cadastrou no sistema
  * Parametros: dataCadastro - Data em que o doador se cadastrou no sistema
  * Retorno: void
  * *************************************************************** */
  public void setDataCadastro(LocalDate dataCadastro) {
    this.dataCadastro = dataCadastro;
  }
}