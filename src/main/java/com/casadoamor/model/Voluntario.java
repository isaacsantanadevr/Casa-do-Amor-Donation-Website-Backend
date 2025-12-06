/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: Voluntario.java
* Funcao...........: Classe modelo que representa um voluntario no sistema.
*************************************************************** */
package com.casadoamor.model;

import com.casadoamor.enums.StatusInscricao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voluntario extends Usuario {
  private LocalDate dataInscricao; // Data em que o voluntario se inscreveu no sistema
  private StatusInscricao statusInscricao; // Status da inscricao do voluntario (PENDENTE, APROVADO, REJEITADO)
  
  private List<VoluntarioAreaAtuacao> areasDeAtuacao = new ArrayList<>(); // Areas de atuacao do voluntario
  /* ***************************************************************
  * Construtor: Voluntario
  * Funcao: Inicializa um novo objeto Voluntario
  * Parametros: Sem parametros.
  * Retorno: void
  * *************************************************************** */
  public Voluntario() {
    super();
  }
  /* ***************************************************************
  * Construtor: Voluntario
  * Funcao: Inicializa um novo objeto Voluntario com os parametros fornecidos
  * Parametros: idUsuario - ID unico do voluntario
  *           nome - Nome do voluntario
                email - Email do voluntario
                cpf - CPF do voluntario
                telefone - Telefone do voluntario
                dataInscricao - Data em que o voluntario se inscreveu no sistema
                statusInscricao - Status da inscricao do voluntario (PENDENTE, APROVADO, REJEITADO)
  * Retorno: void
  * *************************************************************** */
  public Voluntario(long idUsuario, String nome, String email, String cpf, String telefone, LocalDate dataInscricao, StatusInscricao statusInscricao) {
    super(idUsuario, nome, email, cpf, telefone);
    this.dataInscricao = dataInscricao;
    this.statusInscricao = statusInscricao;
  }
  /* ***************************************************************
  * Metodo: getDataInscricao
  * Funcao: Retorna a data em que o voluntario se inscreveu no sistema
  * Parametros: Sem parametros.
  * Retorno: LocalDate - Data em que o voluntario se inscreveu no sistema
  * *************************************************************** */
  public LocalDate getDataInscricao() {
    return dataInscricao;
  }
  /* ***************************************************************
  * Metodo: setDataInscricao
  * Funcao: Define a data em que o voluntario se inscreveu no sistema
  * Parametros: dataInscricao - Data em que o voluntario se inscreveu no sistema
  * Retorno: void
  * *************************************************************** */
  public void setDataInscricao(LocalDate dataInscricao) {
    this.dataInscricao = dataInscricao;
  }
  /* ***************************************************************
  * Metodo: getStatusInscricao
  * Funcao: Retorna o status da inscricao do voluntario
  * Parametros: Sem parametros.
  * Retorno: StatusInscricao - Status da inscricao do voluntario
  * *************************************************************** */
  public StatusInscricao getStatusInscricao() {
    return statusInscricao;
  }
  /* ***************************************************************
  * Metodo: setStatusInscricao
  * Funcao: Define o status da inscricao do voluntario
  * Parametros: statusInscricao - Status da inscricao do voluntario
  * Retorno: void
  * *************************************************************** */
  public void setStatusInscricao(StatusInscricao statusInscricao) {
    this.statusInscricao = statusInscricao;
  }
  /* ***************************************************************
  * Metodo: getAreasDeAtuacao
  * Funcao: Retorna as areas de atuacao do voluntario
  * Parametros: Sem parametros.
  * Retorno: List<VoluntarioAreaAtuacao> - Areas de atuacao do voluntario
  * *************************************************************** */
  public List<VoluntarioAreaAtuacao> getAreasDeAtuacao() {
    return areasDeAtuacao;
  }
  /* ***************************************************************
  * Metodo: setAreasDeAtuacao
  * Funcao: Define as areas de atuacao do voluntario
  * Parametros: areasDeAtuacao - Areas de atuacao do voluntario
  * Retorno: void
  * *************************************************************** */
  public void setAreasDeAtuacao(List<VoluntarioAreaAtuacao> areasDeAtuacao) {
    this.areasDeAtuacao = areasDeAtuacao;
  }
}