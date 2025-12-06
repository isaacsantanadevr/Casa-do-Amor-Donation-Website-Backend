/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: Usuario.java
* Funcao...........: Classe modelo que representa um usuario no sistema.
*************************************************************** */
package com.casadoamor.model;

import java.io.Serializable;

public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L; // Versao da classe para serializacao

  private long idUsuario; // ID unico do usuario
  private String nome; // Nome do usuario
  private String email; // Email do usuario
  private String cpf; // CPF do usuario
  private String telefone; // Telefone do usuario
  /* ***************************************************************
  * Construtor: Usuario
  * Funcao: Inicializa um novo objeto Usuario
  * Parametros: Sem parametros.
  * Retorno: void
  * *************************************************************** */
  public Usuario() {}
  /* ***************************************************************
  * Construtor: Usuario
  * Funcao: Inicializa um novo objeto Usuario com os parametros fornecidos
  * Parametros: idUsuario - ID unico do usuario
  *             nome - Nome do usuario
                email - Email do usuario
                cpf - CPF do usuario
                telefone - Telefone do usuario
  * Retorno: void
  * *************************************************************** */
  public Usuario(long idUsuario, String nome, String email, String cpf, String telefone) {
    this.idUsuario = idUsuario;
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.telefone = telefone;
  }
  /* ***************************************************************
  * Metodo: getIdUsuario
  * Funcao: Retorna o ID unico do usuario
  * Parametros: Sem parametros.
  * Retorno: long - ID unico do usuario
  * *************************************************************** */
  public long getIdUsuario() {
    return idUsuario;
  }
  /* ***************************************************************
  * Metodo: setIdUsuario
  * Funcao: Define o ID unico do usuario
  * Parametros: idUsuario - ID unico do usuario
  * Retorno: void
  * *************************************************************** */
  public void setIdUsuario(long idUsuario) {
    this.idUsuario = idUsuario;
  }
  /* ***************************************************************
  * Metodo: getNome
  * Funcao: Retorna o nome do usuario
  * Parametros: Sem parametros.
  * Retorno: String - Nome do usuario
  * *************************************************************** */
  public String getNome() {
    return nome;
  }
  /* ***************************************************************
  * Metodo: setNome
  * Funcao: Define o nome do usuario
  * Parametros: nome - Nome do usuario
  * Retorno: void
  * *************************************************************** */
  public void setNome(String nome) {
    this.nome = nome;
  }
  /* ***************************************************************
  * Metodo: getEmail
  * Funcao: Retorna o email do usuario
  * Parametros: Sem parametros.
  * Retorno: String - Email do usuario
  * *************************************************************** */
  public String getEmail() {
    return email;
  }
  /* ***************************************************************
  * Metodo: setEmail
  * Funcao: Define o email do usuario
  * Parametros: email - Email do usuario
  * Retorno: void
  * *************************************************************** */
  public void setEmail(String email) {
    this.email = email;
  }
  /* ***************************************************************
  * Metodo: getCpf
  * Funcao: Retorna o CPF do usuario
  * Parametros: Sem parametros.
  * Retorno: String - CPF do usuario
  * *************************************************************** */
  public String getCpf() {
    return cpf;
  }
  /* ***************************************************************
  * Metodo: setCpf
  * Funcao: Define o CPF do usuario
  * Parametros: cpf - CPF do usuario
  * Retorno: void
  * *************************************************************** */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  /* ***************************************************************
  * Metodo: getTelefone
  * Funcao: Retorna o telefone do usuario
  * Parametros: Sem parametros.
  * Retorno: String - Telefone do usuario
  * *************************************************************** */
  public String getTelefone() {
    return telefone;
  }
  /* ***************************************************************
  * Metodo: setTelefone
  * Funcao: Define o telefone do usuario
  * Parametros: telefone - Telefone do usuario
  * Retorno: void
  * *************************************************************** */
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}