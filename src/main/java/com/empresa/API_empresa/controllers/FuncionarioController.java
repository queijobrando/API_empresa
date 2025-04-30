package com.empresa.API_empresa.controllers;

import com.empresa.API_empresa.funcionario.dtos.AtualizarDadosFuncionario;
import com.empresa.API_empresa.funcionario.dtos.DadosCadastroFuncionario;
import com.empresa.API_empresa.funcionario.dtos.DadosDetalhamentoFuncionario;
import com.empresa.API_empresa.funcionario.entities.Funcionario;
import com.empresa.API_empresa.funcionario.services.FuncionarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriComponentsBuilder) {
        Funcionario funcionario = funcionarioService.cadastrarFuncionario(dados);

        var uri = uriComponentsBuilder.path("funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri(); //201

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios(){
        var lista = funcionarioService.listarFuncionario();
        return ResponseEntity.ok(lista); // 200 ok
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhesFuncionario(@PathVariable Long id){
        var funcionario = funcionarioService.carregarFuncionario(id);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody AtualizarDadosFuncionario dados){
        var funcionario = funcionarioService.carregarFuncionario(dados.id());
        funcionario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario)); // NÃO É RECOMENDADO RECEBER E ENVIAR DADOS DA ENTIDADE JPA, DEVE CRIAR UM DTO
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build(); //.build constroi o objeto noContent responseENTITY 204
    }

}
