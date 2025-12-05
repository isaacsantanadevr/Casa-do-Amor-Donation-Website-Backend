package com.casadoamor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.casadoamor.model.Voluntario;
import com.casadoamor.model.VoluntarioAreaAtuacao;
import com.casadoamor.util.ConnectionFactory;
import com.casadoamor.enums.StatusInscricao;

public class VoluntarioDAO implements IVoluntarioDAO {

    public VoluntarioDAO() {
    }

    @Override
    public void salvar(Voluntario voluntario) {
        // 1. Inserir na tabela Pai (Usuario)
        String sqlUsuario = "INSERT INTO usuario (nome, email, cpf, telefone) VALUES (?, ?, ?, ?)";
        // 2. Inserir na tabela Filha (Voluntario)
        String sqlVoluntario = "INSERT INTO voluntario (id_usuario, data_inscricao, status_inscricao) VALUES (?, ?, ?)";
        // 3. Inserir Áreas
        String sqlRelacao = "INSERT INTO voluntario_area_atuacao (id_voluntario, id_area_atuacao, especialidade) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false); // Inicia Transação

            try {
                // Passo 1: Salvar Usuario e pegar ID
                Long idUsuarioGerado = null;
                try (PreparedStatement psUser = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                    psUser.setString(1, voluntario.getNome());
                    psUser.setString(2, voluntario.getEmail());
                    psUser.setString(3, voluntario.getCpf());
                    psUser.setString(4, voluntario.getTelefone());
                    psUser.executeUpdate();

                    try (ResultSet rs = psUser.getGeneratedKeys()) {
                        if (rs.next()) {
                            idUsuarioGerado = rs.getLong(1);
                            voluntario.setIdUsuario(idUsuarioGerado);
                        } else {
                            throw new SQLException("Falha ao obter ID do usuário.");
                        }
                    }
                }

                // Passo 2: Salvar Voluntario usando o mesmo ID
                try (PreparedStatement psVol = conn.prepareStatement(sqlVoluntario)) {
                    psVol.setLong(1, idUsuarioGerado);
                    psVol.setDate(2, Date.valueOf(voluntario.getDataInscricao()));
                    psVol.setString(3, voluntario.getStatusInscricao().name());
                    psVol.executeUpdate();
                }

                // Passo 3: Salvar Áreas de Atuação
                if (voluntario.getAreasDeAtuacao() != null && !voluntario.getAreasDeAtuacao().isEmpty()) {
                    try (PreparedStatement psRel = conn.prepareStatement(sqlRelacao)) {
                        for (VoluntarioAreaAtuacao rel : voluntario.getAreasDeAtuacao()) {
                            psRel.setLong(1, idUsuarioGerado); // Usa o ID do Usuario/Voluntario
                            psRel.setLong(2, rel.getAreaAtuacao().getIdArea());
                            psRel.setString(3, rel.getEspecialidade());
                            psRel.addBatch();
                        }
                        psRel.executeBatch();
                    }
                }

                conn.commit(); // Confirma tudo

            } catch (SQLException e) {
                conn.rollback(); // Desfaz se der erro
                throw e;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar voluntário completo", e);
        }
    }

    @Override
    public List<Voluntario> listar() {
        // JOIN Obrigatório pois os dados estão espalhados
        String sql = "SELECT u.id_usuario, u.nome, u.email, u.cpf, u.telefone, v.data_inscricao, v.status_inscricao " +
                     "FROM voluntario v " +
                     "JOIN usuario u ON v.id_usuario = u.id_usuario";
        
        List<Voluntario> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Voluntario v = new Voluntario();
                v.setIdUsuario(rs.getLong("id_usuario"));
                v.setNome(rs.getString("nome"));
                v.setEmail(rs.getString("email"));
                v.setCpf(rs.getString("cpf"));
                v.setTelefone(rs.getString("telefone"));
                
                Date data = rs.getDate("data_inscricao");
                if (data != null) v.setDataInscricao(data.toLocalDate());
                
                String statusStr = rs.getString("status_inscricao");
                if (statusStr != null) v.setStatusInscricao(StatusInscricao.valueOf(statusStr));
                
                lista.add(v);
            }
        } catch (SQLException e) {
            Logger.getLogger(VoluntarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Erro ao listar voluntários", e);
        }
        return lista;
    }

    public void atualizarStatus(Long idUsuario, StatusInscricao novoStatus) {
        String sql = "UPDATE voluntario SET status_inscricao = ? WHERE id_usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoStatus.name());
            ps.setLong(2, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar status do voluntário", e);
        }
    }

    // --- NOVOS MÉTODOS PARA UPDATE E DELETE ---

    public Voluntario buscarPorId(Long id) {
        String sql = "SELECT u.id_usuario, u.nome, u.email, u.cpf, u.telefone, v.data_inscricao, v.status_inscricao " +
                     "FROM voluntario v JOIN usuario u ON v.id_usuario = u.id_usuario WHERE v.id_usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Voluntario v = new Voluntario();
                    v.setIdUsuario(rs.getLong("id_usuario"));
                    v.setNome(rs.getString("nome"));
                    v.setEmail(rs.getString("email"));
                    v.setCpf(rs.getString("cpf"));
                    v.setTelefone(rs.getString("telefone"));
                    
                    Date data = rs.getDate("data_inscricao");
                    if (data != null) v.setDataInscricao(data.toLocalDate());
                    
                    String statusStr = rs.getString("status_inscricao");
                    if (statusStr != null) v.setStatusInscricao(StatusInscricao.valueOf(statusStr));
                    
                    return v;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar voluntário por ID", e);
        }
        return null;
    }

    public void atualizar(Voluntario voluntario) {
        String sqlUser = "UPDATE usuario SET nome=?, email=?, cpf=?, telefone=? WHERE id_usuario=?";
        // Áreas: Apaga tudo e insere de novo (estratégia mais segura para N:N simples)
        String sqlDelAreas = "DELETE FROM voluntario_area_atuacao WHERE id_voluntario=?";
        String sqlInsAreas = "INSERT INTO voluntario_area_atuacao (id_voluntario, id_area_atuacao, especialidade) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // 1. Atualiza dados pessoais (Tabela Pai)
                try (PreparedStatement ps = conn.prepareStatement(sqlUser)) {
                    ps.setString(1, voluntario.getNome());
                    ps.setString(2, voluntario.getEmail());
                    ps.setString(3, voluntario.getCpf());
                    ps.setString(4, voluntario.getTelefone());
                    ps.setLong(5, voluntario.getIdUsuario());
                    ps.executeUpdate();
                }

                // Nota: Geralmente não atualizamos data_inscricao ou status num update cadastral comum, 
                // mas se precisasse, seria um UPDATE na tabela voluntario aqui.

                // 2. Atualiza Áreas (Remove antigas -> Insere novas)
                try (PreparedStatement ps = conn.prepareStatement(sqlDelAreas)) {
                    ps.setLong(1, voluntario.getIdUsuario());
                    ps.executeUpdate();
                }
                if (voluntario.getAreasDeAtuacao() != null && !voluntario.getAreasDeAtuacao().isEmpty()) {
                    try (PreparedStatement ps = conn.prepareStatement(sqlInsAreas)) {
                        for (VoluntarioAreaAtuacao rel : voluntario.getAreasDeAtuacao()) {
                            ps.setLong(1, voluntario.getIdUsuario());
                            ps.setLong(2, rel.getAreaAtuacao().getIdArea());
                            ps.setString(3, rel.getEspecialidade());
                            ps.addBatch();
                        }
                        ps.executeBatch();
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar voluntário", e);
        }
    }

    public void excluir(Long idUsuario) {
        // A ordem de exclusão importa por causa das chaves estrangeiras (FK)
        String sqlAreas = "DELETE FROM voluntario_area_atuacao WHERE id_voluntario = ?";
        String sqlVol = "DELETE FROM voluntario WHERE id_usuario = ?";
        String sqlUser = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false); // Transação obrigatória
            try {
                // 1. Remove dependências (Áreas)
                try (PreparedStatement ps = conn.prepareStatement(sqlAreas)) {
                    ps.setLong(1, idUsuario);
                    ps.executeUpdate();
                }
                // 2. Remove Voluntário
                try (PreparedStatement ps = conn.prepareStatement(sqlVol)) {
                    ps.setLong(1, idUsuario);
                    ps.executeUpdate();
                }
                // 3. Remove Usuário
                try (PreparedStatement ps = conn.prepareStatement(sqlUser)) {
                    ps.setLong(1, idUsuario);
                    ps.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir voluntário", e);
        }
    }
}