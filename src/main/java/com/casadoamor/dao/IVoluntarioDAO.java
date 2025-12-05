/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: IVoluntarioDAO.java
* Funcao...........: Interface DAO para gerenciar voluntarios no BD
*************************************************************** */
package com.casadoamor.dao;

import java.util.List;
import com.casadoamor.model.Voluntario;

/* ***************************************************************
* Interface: IVoluntarioDAO
* Funcao: Define os metodos para interagir com o banco de dados de voluntarios.
* Metodos:
*   - salvar(Voluntario voluntario): Salva um novo voluntario no banco.
*   - listar(): Retorna uma lista de todos os voluntarios cadastrados.
*************************************************************** */
public interface IVoluntarioDAO {
  void salvar(Voluntario voluntario); // Para a feature 2.1
  List<Voluntario> listar(); // Para a feature 2.2
}