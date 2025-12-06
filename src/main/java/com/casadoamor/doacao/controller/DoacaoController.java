/* ***************************************************************
* Projeto.........: Casa do Amor
* Autores.........: Caio Cordeiro, Cibelly Batista, Gabriel Marcone, Isaac Santana, Joao Guilherme
* Nome.............: DoacaoController.java
* Funcao...........: Classe responsavel por gerenciar as requisicoes relacionadas a doacoes
*************************************************************** */
package com.casadoamor.doacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Import novo
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadoamor.doacao.dto.CriarDoacaoRequest;
import com.casadoamor.doacao.dto.CriarDoacaoResponse;
import com.casadoamor.doacao.model.Doacao;
import com.casadoamor.doacao.service.DoacaoService;
import java.util.List;

@RestController // Indica que esta classe e um controlador REST
@RequestMapping("/doacoes") // Mapeia as requisicoes para /doacoes
@CrossOrigin(origins = "*") // Permite requisicoes de qualquer origem
public class DoacaoController {
  @Autowired
  private DoacaoService doacaoService; // Injecao do DoacaoService
  /* ***************************************************************
  * Metodo: listarDoacoes
  * Funcao: Retorna uma lista com todas as doacoes cadastradas.
  * Parametros: Sem parametros.
  * Retorno: ResponseEntity<List<Doacao>> - Lista de doacoes com status HTTP 200.
  *************************************************************** */
  @GetMapping
  public ResponseEntity<List<Doacao>> listarDoacoes() {
    // Chama o Service -> DAO -> Banco de Dados
    List<Doacao> lista = doacaoService.listarTodas();
    return ResponseEntity.ok(lista);
  }
  /* ***************************************************************
  * Metodo: criarDoacaoResponse
  * Funcao: Cria uma nova doacao no sistema a partir dos dados da requisicao.
  * Parametros: request - Objeto CriarDoacaoRequest contendo os dados da doacao.
  * Retorno: CriarDoacaoResponse - Resposta com os dados da doacao criada.
  *************************************************************** */
  @PostMapping
  public CriarDoacaoResponse criarDoacaoResponse(@RequestBody CriarDoacaoRequest request){
    return doacaoService.criarDoacao(request);
  }
  /* ***************************************************************
  * Metodo: buscarDoacao
  * Funcao: Busca uma doacao especifica pelo seu ID.
  * Parametros: id - ID da doacao a ser buscada.
  * Retorno: Doacao - Objeto Doacao encontrado.
  *************************************************************** */
  @GetMapping("/{id}")
  public Doacao buscarDoacao(@PathVariable Long id) {
    return doacaoService.buscarPorId(id);
  }
}