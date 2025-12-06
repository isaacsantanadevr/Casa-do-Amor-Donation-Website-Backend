/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Carolina Moraes, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: DoacaoDAO.java
* Funcao...........: DAO para gerenciar doacoes no banco de dados
*************************************************************** */
package com.casadoamor.doacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List; 
import com.casadoamor.doacao.enums.StatusDoacao;
import com.casadoamor.doacao.model.Doacao;
import com.casadoamor.util.ConnectionFactory;

public class DoacaoDAO {
  /* ***************************************************************
  * Construtor: DoacaoDAO
  * Funcao: Construtor da classe DoacaoDAO.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public DoacaoDAO() {}
  /* ***************************************************************
  * Metodo: salvarDoacao
  * Funcao: Salva uma nova doacao no banco de dados.
  * Parametros: doacao - Objeto Doacao com dados a serem salvos.
  * Retorno: void
  *************************************************************** */
  public void salvarDoacao(Doacao doacao) {
    String sql = "INSERT INTO Doacao (valor, moeda, statusDoacao, referenciaExt, idempotencyKey, nomeDoador, emailDoador, criadoEm, atualizadoEm, pagamentoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = ConnectionFactory.getConnection();
    PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      // Preenche os parametros da query com os dados da doacao
      pstm.setBigDecimal(1, doacao.getValor());
      pstm.setString(2, doacao.getMoeda());
      pstm.setString(3, doacao.getStatusDoacao() != null ? doacao.getStatusDoacao().name() : StatusDoacao.PENDING.name());
      pstm.setString(4, doacao.getReferenciaExt());
      pstm.setString(5, doacao.getIdempotencyKey());
      pstm.setString(6, doacao.getNomeDoador());
      pstm.setString(7, doacao.getEmailDoador());
      pstm.setTimestamp(8, doacao.getCriadoEm() != null ? Timestamp.valueOf(doacao.getCriadoEm()) : null);
      pstm.setTimestamp(9, doacao.getAtualizadoEm() != null ? Timestamp.valueOf(doacao.getAtualizadoEm()) : null);
      pstm.setString(10, doacao.getPagamentoId());

      pstm.executeUpdate();

      // Obtem o ID gerado automaticamente pelo banco de dados
      try (ResultSet rs = pstm.getGeneratedKeys()) {
        if (rs.next()) {
          doacao.setId(rs.getLong(1));
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao salvar doação no banco de dados", e);
    }
  }
  /* ***************************************************************
  * Metodo: listarTodas
  * Funcao: Retorna uma lista de todas as doacoes cadastradas, ordenadas por data de criacao.
  * Parametros: Sem parametros.
  * Retorno: List<Doacao> - Lista de doacoes.
  *************************************************************** */
  public List<Doacao> listarTodas() {
    String sql = "SELECT * FROM Doacao ORDER BY criadoEm DESC";
    List<Doacao> lista = new ArrayList<>();

    try (Connection connection = ConnectionFactory.getConnection();
    PreparedStatement pstm = connection.prepareStatement(sql);
    ResultSet rs = pstm.executeQuery()) {
      // Itera sobre o resultado da consulta
      while (rs.next()) {
        lista.add(mapearResultSet(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao listar doações", e);
    }
    return lista;
  }
  /* ***************************************************************
  * Metodo: buscarPorId
  * Funcao: Busca uma doacao pelo seu ID.
  * Parametros: id - ID da doacao a ser buscada.
  * Retorno: Doacao - Objeto Doacao encontrado ou null.
  *************************************************************** */
  public Doacao buscarPorId(Long id) {
    if (id == null) return null;
    
    String sql = "SELECT * FROM Doacao WHERE id = ?";
    try (Connection connection = ConnectionFactory.getConnection();
    PreparedStatement pstm = connection.prepareStatement(sql)) {
      pstm.setLong(1, id);
      
      try (ResultSet rs = pstm.executeQuery()) {
        if (rs.next()) {
          return mapearResultSet(rs);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao buscar doação por ID", e);
    }
    return null;
  }
  /* ***************************************************************
  * Metodo: buscaPorRefEx
  * Funcao: Busca uma doacao pela sua referencia externa.
  * Parametros: referenciaExterna - Codigo de referencia externa da doacao.
  * Retorno: Doacao - Objeto Doacao encontrado ou null.
  *************************************************************** */
  public Doacao buscaPorRefEx(String referenciaExterna) {
    if (referenciaExterna == null) return null;

    String sql = "SELECT * FROM Doacao WHERE referenciaExt = ?";
    try (Connection connection = ConnectionFactory.getConnection();
    PreparedStatement pstm = connection.prepareStatement(sql)) {
      pstm.setString(1, referenciaExterna);
      
      try (ResultSet rs = pstm.executeQuery()) {
        if (rs.next()) {
          return mapearResultSet(rs);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao buscar doação por referência externa", e);
    }
    return null;
  }
  /* ***************************************************************
  * Metodo: atualizarDoacao
  * Funcao: Atualiza os dados de uma doacao no banco de dados.
  * Parametros: doacao - Objeto Doacao com dados atualizados.
  * Retorno: void
  *************************************************************** */
  public void atualizarDoacao(Doacao doacao) {
    if (doacao == null || doacao.getId() == null) return;

    String sql = "UPDATE Doacao SET statusDoacao = ?, pagamentoId = ?, atualizadoEm = ? WHERE id = ?";

    try (Connection connection = ConnectionFactory.getConnection();
    PreparedStatement pstm = connection.prepareStatement(sql)) {
      pstm.setString(1, doacao.getStatusDoacao().name());
      pstm.setString(2, doacao.getPagamentoId());
      pstm.setTimestamp(3, doacao.getAtualizadoEm() != null ? Timestamp.valueOf(doacao.getAtualizadoEm()) : null);
      pstm.setLong(4, doacao.getId());

      pstm.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException("Erro ao atualizar doação", e);
    }
  }
  /* ***************************************************************
  * Metodo: atualizarStatusDoacao
  * Funcao: Atualiza apenas o status de uma doacao.
  * Parametros: id - ID da doacao a ser atualizada.
                status - Novo status da doacao.
  * Retorno: void
  *************************************************************** */
  public void atualizarStatusDoacao(Long id, StatusDoacao status) {
    if (id == null || status == null) return;

    String sql = "UPDATE Doacao SET statusDoacao = ? WHERE id = ?";
    try (Connection connection = ConnectionFactory.getConnection();
    PreparedStatement pstm = connection.prepareStatement(sql)) {
      pstm.setString(1, status.name());
      pstm.setLong(2, id);
      
      pstm.executeUpdate();
        
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao atualizar status da doação", e);
    }
  }
  /* ***************************************************************
  * Metodo: mapearResultSet
  * Funcao: Mapeia os dados de um ResultSet para um objeto Doacao.
  * Parametros: rs - ResultSet com os dados do banco de dados.
  * Retorno: Doacao - Objeto Doacao populado.
  *************************************************************** */
  private Doacao mapearResultSet(ResultSet rs) throws SQLException {
    Doacao d = new Doacao();
    d.setId(rs.getLong("id"));
    d.setValor(rs.getBigDecimal("valor"));
    d.setMoeda(rs.getString("moeda"));
    d.setReferenciaExt(rs.getString("referenciaExt"));
    d.setIdempotencyKey(rs.getString("idempotencyKey"));
    d.setPagamentoId(rs.getString("pagamentoId"));
    d.setNomeDoador(rs.getString("nomeDoador"));
    d.setEmailDoador(rs.getString("emailDoador"));
    
    // Converte string do banco para enum StatusDoacao
    String statusStr = rs.getString("statusDoacao");
    if (statusStr != null) {
      d.setStatusDoacao(StatusDoacao.valueOf(statusStr));
    }

    // Converte Timestamp para LocalDateTime
    Timestamp criadoEm = rs.getTimestamp("criadoEm");
    if (criadoEm != null) {
      d.setCriadoEm(criadoEm.toLocalDateTime());
    }

    Timestamp atualizadoEm = rs.getTimestamp("atualizadoEm");
    if (atualizadoEm != null) {
      d.setAtualizadoEm(atualizadoEm.toLocalDateTime());
    }
    return d;
  }
}