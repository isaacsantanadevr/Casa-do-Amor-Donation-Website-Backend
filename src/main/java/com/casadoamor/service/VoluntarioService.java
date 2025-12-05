/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: VoluntarioService.java
* Funcao...........: Servico para gerenciar inscricoes de voluntarios
*************************************************************** */
package com.casadoamor.service;

import java.time.LocalDate;
import com.casadoamor.enums.StatusInscricao;
import com.casadoamor.model.AreaAtuacao;
import com.casadoamor.model.Voluntario;
import com.casadoamor.dao.VoluntarioDAO;
import java.util.List;
import com.casadoamor.dao.AreaAtuacaoDAO;

public class VoluntarioService {
  private VoluntarioDAO voluntarioDAO; // DAO para interagir com o banco de dados
  private AreaAtuacaoDAO areaAtuacaoDAO; // DAO para interagir com o banco de dados
  /* ***************************************************************
  * Construtor: VoluntarioService
  * Funcao: Criar instancias dos DAOs para uso nos metodos do servico
  * Parametros: Nao possui parametros
  * Retorno: Nao possui retorno
  * *************************************************************** */
  public VoluntarioService() {
    this.voluntarioDAO = new VoluntarioDAO();
    this.areaAtuacaoDAO = new AreaAtuacaoDAO();
  }
  /* ***************************************************************
  * Metodo: registrarInscricao
  * Funcao: Registrar uma nova inscricao de voluntario. Valida os dados e salva a inscricao no banco de dados
  * Parametros: voluntario - Objeto Voluntario contendo os dados da inscricao
  * Retorno: void
  * *************************************************************** */
  public void registrarInscricao(Voluntario voluntario) throws Exception {
    // Validacao dos dados obrigatorios
    if (voluntario.getNome() == null || voluntario.getNome().trim().isEmpty()) {
      throw new Exception("O campo 'Nome' é obrigatório.");
    }
    if (voluntario.getEmail() == null || voluntario.getEmail().trim().isEmpty()) {
      throw new Exception("O campo 'Email' é obrigatório.");
    }
    if(voluntario.getCpf() == null || voluntario.getCpf().trim().isEmpty()){
      throw new Exception("O campo 'CPF' é obrigatório.");
    }
    if(voluntario.getTelefone() == null || voluntario.getTelefone().trim().isEmpty()){
      throw new Exception("O campo 'Telefone' é obrigatório.");
    }
    if(voluntario.getDataInscricao() == null){
      throw new Exception("O campo 'Data Inscrição' é obrigatório.");
    }

    voluntario.setStatusInscricao(StatusInscricao.PENDENTE_ANALISE); // Define o status inicial como PENDENTE_ANALISE

    // Salva a inscricao no banco de dados
    try {
      voluntarioDAO.salvar(voluntario); 
    } catch (Exception e){
      throw new Exception("Erro ao salvar inscrição no banco de dados: " + e.getMessage());
    }
  }
  /* ***************************************************************
  * Metodo: listarInscricoes
  * Funcao: Recuperar todas as inscricoes de voluntarios do banco de dados
  * Parametros: Nao possui parametros
  * Retorno: Lista de objetos Voluntario representando as inscricoes
  * *************************************************************** */
  public List<Voluntario> listarInscricoes() {
    return voluntarioDAO.listar();
  }
  /* ***************************************************************
  * Metodo: buscarAreasParaDropdown
  * Funcao: Recuperar todas as areas de atuacao disponiveis para popular dropdown
  * Parametros: Nao possui parametros
  * Retorno: Lista de objetos AreaAtuacao
  * *************************************************************** */
  public List<AreaAtuacao> buscarAreasParaDropdown() {
    return areaAtuacaoDAO.listar();
  }
  /* ***************************************************************
  * Metodo: atualizarVoluntario
  * Funcao: Atualizar os dados de um voluntario existente
  * Parametros: id - ID do voluntario a ser atualizado
                voluntario - Objeto Voluntario com os novos dados
  * Retorno: void
  * *************************************************************** */
  public void atualizarVoluntario(Long id, Voluntario voluntario) throws Exception {
    // Validacao dos dados obrigatorios
    if (id == null) throw new Exception("ID é obrigatório");
    // Verifica se o voluntario existe
    if (voluntarioDAO.buscarPorId(id) == null) {
      throw new Exception("Voluntário não encontrado.");
    }
    // Atualiza os dados
    voluntario.setIdUsuario(id);

    if (voluntario.getNome() == null || voluntario.getNome().trim().isEmpty()) throw new Exception("Nome obrigatório.");

    voluntarioDAO.atualizar(voluntario); // Atualiza no banco de dados
  }
  /* ***************************************************************
  * Metodo: excluirVoluntario
  * Funcao: Excluir um voluntario do banco de dados
  * Parametros: id - ID do voluntario a ser excluido
  * Retorno: void
  * *************************************************************** */
  public void excluirVoluntario(Long id) throws Exception {
    // Verifica se o voluntario existe
    if (voluntarioDAO.buscarPorId(id) == null) {
      throw new Exception("Voluntário não encontrado.");
    }
    voluntarioDAO.excluir(id); // Exclui do banco de dados
  }
}