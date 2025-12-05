/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: VoluntarioAreaAtuacao.java
* Funcao...........: Classe modelo que representa a relacao entre um voluntario e sua area de atuacao.
*************************************************************** */
package com.casadoamor.model;

public class VoluntarioAreaAtuacao {
  // Foreign keys
  private Voluntario voluntario; // Voluntario associado
  private AreaAtuacao areaAtuacao; // Area de atuacao associada
  
  private String especialidade; // Especialidade do voluntario na area de atuacao
  private String disponibilidade; // Disponibilidade do voluntario para atuar na area
  /* ***************************************************************
  * Construtor: VoluntarioAreaAtuacao
  * Funcao: Inicializa um novo objeto VoluntarioAreaAtuacao
  * Parametros: Sem parametros.
  * Retorno: void
  * *************************************************************** */
  public VoluntarioAreaAtuacao() {}
  /* ***************************************************************
  * Construtor: VoluntarioAreaAtuacao
  * Funcao: Inicializa um novo objeto VoluntarioAreaAtuacao com os parametros fornecidos
  * Parametros: voluntario - Voluntario associado
                areaAtuacao - Area de atuacao associada
                especialidade - Especialidade do voluntario na area de atuacao
                disponibilidade - Disponibilidade do voluntario para atuar na area
  * Retorno: void
  * *************************************************************** */
  public VoluntarioAreaAtuacao(Voluntario voluntario, AreaAtuacao areaAtuacao, String especialidade, String disponibilidade) {
    this.voluntario = voluntario;
    this.areaAtuacao = areaAtuacao;
    this.especialidade = especialidade;
    this.disponibilidade = disponibilidade;
  }
  /* ***************************************************************
  * Metodo: getVoluntario
  * Funcao: Retorna o voluntario associado
  * Parametros: Sem parametros.
  * Retorno: Voluntario - Voluntario associado
  * *************************************************************** */
  public Voluntario getVoluntario() {
    return voluntario;
  }
  /* ***************************************************************
  * Metodo: setVoluntario
  * Funcao: Define o voluntario associado
  * Parametros: voluntario - Voluntario associado
  * Retorno: void
  * *************************************************************** */
  public void setVoluntario(Voluntario voluntario) {
    this.voluntario = voluntario;
  }
  /* ***************************************************************
  * Metodo: getAreaAtuacao
  * Funcao: Retorna a area de atuacao associada
  * Parametros: Sem parametros.
  * Retorno: AreaAtuacao - Area de atuacao associada
  * *************************************************************** */
  public AreaAtuacao getAreaAtuacao() {
    return areaAtuacao;
  }
  /* ***************************************************************
  * Metodo: setAreaAtuacao
  * Funcao: Define a area de atuacao associada
  * Parametros: areaAtuacao - Area de atuacao associada
  * Retorno: void
  * *************************************************************** */
  public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
    this.areaAtuacao = areaAtuacao;
  }
  /* ***************************************************************
  * Metodo: getEspecialidade
  * Funcao: Retorna a especialidade do voluntario na area de atuacao
  * Parametros: Sem parametros.
  * Retorno: String - Especialidade do voluntario na area de atuacao
  * *************************************************************** */
  public String getEspecialidade() {
    return especialidade;
  }
  /* ***************************************************************
  * Metodo: setEspecialidade
  * Funcao: Define a especialidade do voluntario na area de atuacao
  * Parametros: especialidade - Especialidade do voluntario na area de atuacao
  * Retorno: void
  * *************************************************************** */
  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }
  /* ***************************************************************
  * Metodo: getDisponibilidade
  * Funcao: Retorna a disponibilidade do voluntario para atuar na area
  * Parametros: Sem parametros.
  * Retorno: String - Disponibilidade do voluntario para atuar na area
  * *************************************************************** */
  public String getDisponibilidade() {
    return disponibilidade;
  }
  /* ***************************************************************
  * Metodo: setDisponibilidade
  * Funcao: Define a disponibilidade do voluntario para atuar na area
  * Parametros: disponibilidade - Disponibilidade do voluntario para atuar na area
  * Retorno: void
  * *************************************************************** */
  public void setDisponibilidade(String disponibilidade) {
    this.disponibilidade = disponibilidade;
  }
}