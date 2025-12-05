/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: CasaDoAmorApplication.java
* Funcao...........: Classe principal para iniciar a aplicacao Spring Boot
*************************************************************** */
package com.casadoamor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotacao para indicar que esta eh a classe principal do Spring Boot
public class CasaDoAmorApplication {
  /* ***************************************************************
  * Metodo: main
  * Funcao: Ponto de entrada da aplicacao Spring Boot
  * Parametros: args - Argumentos da linha de comando
  * Retorno: void
  * Descricao: Inicia a aplicacao Spring Boot
  * *************************************************************** */
  public static void main(String[] args) {
    SpringApplication.run(CasaDoAmorApplication.class, args); // Inicia a aplicacao Spring Boot
  }
}