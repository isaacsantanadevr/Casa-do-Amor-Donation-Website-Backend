/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: VoluntarioController.java
* Funcao...........: Controlador REST para gerenciar inscricoes de voluntarios
*************************************************************** */
package com.casadoamor.controller;

import com.casadoamor.model.AreaAtuacao;
import com.casadoamor.model.Voluntario;
import com.casadoamor.service.VoluntarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/voluntarios") // Rota base para voluntários
@CrossOrigin(origins = "*") // Permitir requisicoes de qualquer origem (ajuda no desenvolvimento front-end)
public class VoluntarioController {
  private final VoluntarioService voluntarioService; // Serviço para logica de negocios

  /* ***************************************************************
  * Metodo: VoluntarioController
  * Funcao: Construtor da classe VoluntarioController.
  * Parametros: Sem parametros.
  * Retorno: void
  *************************************************************** */
  public VoluntarioController(){
    this.voluntarioService = new VoluntarioService();
  }
  /* ***************************************************************
  * Metodo: receberInscricao
  * Funcao: Recebe inscricoes de voluntarios via endpoint /inscricao.
  * Parametros: voluntario - Objeto Voluntario com dados da inscricao.
  * Retorno: ResponseEntity<String> - Mensagem de sucesso ou erro.
  * *************************************************************** */
  @PostMapping("/inscricao") // Endpoint para receber inscricoes
  public ResponseEntity<String> receberInscricao(@RequestBody Voluntario voluntario){
    try{
      voluntarioService.registrarInscricao(voluntario);

      return ResponseEntity.ok("Inscrição realizada com sucesso! Aguarde nosso contato");
    } catch(Exception e){
      return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
    }
  }
  /* ***************************************************************
  * Metodo: listarInscricoes
  * Funcao: Lista todas as inscricoes de voluntarios via endpoint /admin/lista.
  * Parametros: Sem parametros.
  * Retorno: ResponseEntity<List<Voluntario>> - Lista de voluntarios em JSON.
  * *************************************************************** */
  @GetMapping("/admin/lista") // Endpoint para listar inscricoes (admin)
  public ResponseEntity<List<Voluntario>> listarInscricoes() {
    // Busca a lista lá do banco (via Service -> DAO -> JDBC)
    List<Voluntario> lista = voluntarioService.listarInscricoes();
    
    // O Spring Boot converte automaticamente a List<Voluntario> para JSON aqui
    return ResponseEntity.ok(lista);
  }
  /* ***************************************************************
  * Metodo: listarAreas
  * Funcao: Lista todas as areas de atuacao via endpoint /areas-atuacao.
  * Parametros: Sem parametros.
  * Retorno: ResponseEntity<List<AreaAtuacao>> - Lista de areas de atuacao em JSON.
  * *************************************************************** */
  @GetMapping("/areas-atuacao") // Endpoint para listar areas de atuacao
  public ResponseEntity<List<AreaAtuacao>> listarAreas() {
    List<AreaAtuacao> areas = voluntarioService.buscarAreasParaDropdown();
    return ResponseEntity.ok(areas);
  }
  /* ***************************************************************
  * Metodo: atualizarVoluntario
  * Funcao: Atualiza os dados de um voluntario via endpoint /{id}.
  * Parametros: id - ID do voluntario a ser atualizado.
                voluntario - Objeto Voluntario com os novos dados.
  * Retorno: ResponseEntity<String> - Mensagem de sucesso ou erro.
  * *************************************************************** */
  @PutMapping("/{id}") // Atualizar voluntário
  public ResponseEntity<String> atualizarVoluntario(@PathVariable Long id, @RequestBody Voluntario voluntario) {
    try {
      voluntarioService.atualizarVoluntario(id, voluntario);
      return ResponseEntity.ok("Cadastro de voluntário atualizado com sucesso.");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Erro ao atualizar: " + e.getMessage());
    }
  }
  /* ***************************************************************
  * Metodo: excluirVoluntario
  * Funcao: Exclui um voluntario via endpoint /admin/{id}.
  * Parametros: id - ID do voluntario a ser excluído.
  * Retorno: ResponseEntity<String> - Mensagem de sucesso ou erro.
  * *************************************************************** */
  @DeleteMapping("/admin/{id}") // Excluir voluntário
  public ResponseEntity<String> excluirVoluntario(@PathVariable Long id) {
    try {
      voluntarioService.excluirVoluntario(id);
      return ResponseEntity.ok("Voluntário excluído com sucesso.");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Erro ao excluir: " + e.getMessage());
    }
  }
}