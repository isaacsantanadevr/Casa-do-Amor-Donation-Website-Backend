/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: ConnectionFactory.java
* Funcao...........: Fabrica de conexoes com o banco de dados
*************************************************************** */
package com.casadoamor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  // Configuracoes de conexao com o banco de dados
  private static final String URL = "jdbc:postgresql://localhost:5432/casadoamor_db";
  private static final String USER = "postgres";
  private static final String PASSWORD = "admin";
  /* ***************************************************************
  * Metodo: getConnection
  * Funcao: Estabelecer e retornar uma conexao com o banco de dados
  * Parametros: Nao possui parametros
  * Retorno: Objeto Connection representando a conexao com o banco de dados
  * *************************************************************** */
  public static Connection getConnection() {
    try {
      // Carrega o driver JDBC do PostgreSQL
      Class.forName("org.postgresql.Driver"); 
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Erro ao conectar ao banco de dados", e);
    }
  }
}