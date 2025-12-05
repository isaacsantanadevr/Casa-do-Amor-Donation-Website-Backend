/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: Administrador.java
* Funcao...........: Classe modelo que representa um administrador do sistema.
*************************************************************** */
package com.casadoamor.model;

import com.casadoamor.enums.NivelAcesso;
import com.casadoamor.enums.StatusUsuario;

public class Administrador extends Usuario {
  private String senhaHash; // Armazena a senha do administrador em formato hash
  private StatusUsuario status; // Indica o status do administrador (ATIVO, INATIVO, SUSPENSO)
  private NivelAcesso nivelAcesso; // Indica o nivel de acesso do administrador
  /* ***************************************************************
  * Construtor: Administrador
  * Funcao: Inicializa um novo objeto Administrador
  * Parametros: Sem parametros.
  * Retorno: void
  * *************************************************************** */
  public Administrador() {
    super();
  }
  /* ***************************************************************
  * Construtor: Administrador
  * Funcao: Inicializa um novo objeto Administrador com os parametros fornecidos
  * Parametros: idUsuario - ID unico do administrador
                nome - Nome do administrador
                email - Email do administrador
                cpf - CPF do administrador
                telefone - Telefone do administrador
                senhaHash - Senha do administrador em formato hash
                status - Status do administrador (ATIVO, INATIVO, SUSPENSO)
                nivelAcesso - Nivel de acesso do administrador
  * Retorno: void
  * *************************************************************** */
  public Administrador(long idUsuario, String nome, String email, String cpf, String telefone, String senhaHash, StatusUsuario status, NivelAcesso nivelAcesso) {
    super(idUsuario, nome, email, cpf, telefone);
    this.senhaHash = senhaHash;
    this.status = status;
    this.nivelAcesso = nivelAcesso;
  }
  /* ***************************************************************
  * Metodo: getSenhaHash
  * Funcao: Retorna a senha do administrador em formato hash
  * Parametros: Sem parametros.
  * Retorno: String - Senha do administrador em formato hash
  * *************************************************************** */
  public String getSenhaHash() {
    return senhaHash;
  }
  /* ***************************************************************
  * Metodo: setSenhaHash
  * Funcao: Define a senha do administrador em formato hash
  * Parametros: senhaHash - Senha do administrador em formato hash
  * Retorno: void
  * *************************************************************** */
  public void setSenhaHash(String senhaHash) {
    this.senhaHash = senhaHash;
  }
  /* ***************************************************************
  * Metodo: getStatus
  * Funcao: Retorna o status do administrador
  * Parametros: Sem parametros.
  * Retorno: StatusUsuario - Status do administrador
  * *************************************************************** */
  public StatusUsuario getStatus() {
    return status;
  }
  /* ***************************************************************
  * Metodo: setStatus
  * Funcao: Define o status do administrador
  * Parametros: status - Status do administrador
  * Retorno: void
  * *************************************************************** */
  public void setStatus(StatusUsuario status) {
    this.status = status;
  }
  /* ***************************************************************
  * Metodo: getNivelAcesso
  * Funcao: Retorna o nivel de acesso do administrador
  * Parametros: Sem parametros.
  * Retorno: NivelAcesso - Nivel de acesso do administrador
  * *************************************************************** */
  public NivelAcesso getNivelAcesso() {
    return nivelAcesso;
  }
  /* ***************************************************************
  * Metodo: setNivelAcesso
  * Funcao: Define o nivel de acesso do administrador
  * Parametros: nivelAcesso - Nivel de acesso do administrador
  * Retorno: void
  * *************************************************************** */
  public void setNivelAcesso(NivelAcesso nivelAcesso) {
    this.nivelAcesso = nivelAcesso;
  }
}