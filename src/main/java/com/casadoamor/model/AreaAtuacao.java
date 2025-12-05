/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: AreaAtuacao.java
* Funcao...........: Classe modelo que representa uma area de atuacao dentro do sistema.
*************************************************************** */
package com.casadoamor.model;

public class AreaAtuacao {
  private long idArea; // ID unico da area de atuacao
  private String nome; // Nome da area de atuacao
  /* ***************************************************************
  * Construtor: AreaAtuacao
  * Funcao: Inicializa um novo objeto AreaAtuacao
  * Parametros: Sem parametros.
  * Retorno: void
  * *************************************************************** */
  public AreaAtuacao() {}
  /* ***************************************************************
  * Construtor: AreaAtuacao
  * Funcao: Inicializa um novo objeto AreaAtuacao com os parametros fornecidos
  * Parametros: idArea - ID unico da area de atuacao
                nome - Nome da area de atuacao
  * Retorno: void
  * *************************************************************** */
  public AreaAtuacao(long idArea, String nome) {
    this.idArea = idArea;
    this.nome = nome;
  }
  /* ***************************************************************
  * Metodo: getIdArea
  * Funcao: Retorna o ID unico da area de atuacao
  * Parametros: Sem parametros.
  * Retorno: long - ID unico da area de atuacao
  * *************************************************************** */
  public long getIdArea() {
    return idArea;
  }
  /* ***************************************************************
  * Metodo: setIdArea
  * Funcao: Define o ID unico da area de atuacao
  * Parametros: idArea - ID unico da area de atuacao
  * Retorno: void
  * *************************************************************** */
  public void setIdArea(long idArea) {
    this.idArea = idArea;
  }
  /* ***************************************************************
  * Metodo: getNome
  * Funcao: Retorna o nome da area de atuacao
  * Parametros: Sem parametros.
  * Retorno: String - Nome da area de atuacao
  * *************************************************************** */
  public String getNome() {
    return nome;
  }
  /* ***************************************************************
  * Metodo: setNome
  * Funcao: Define o nome da area de atuacao
  * Parametros: nome - Nome da area de atuacao
  * Retorno: void
  * *************************************************************** */
  public void setNome(String nome) {
    this.nome = nome;
  }
}