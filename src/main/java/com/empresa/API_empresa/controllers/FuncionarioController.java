package com.empresa.API_empresa.controllers;

import com.empresa.API_empresa.funcionario.entities.AtualizarDadosFuncionario;
import com.empresa.API_empresa.funcionario.entities.DadosCadastroFuncionario;
import com.empresa.API_empresa.funcionario.entities.Funcionario;
import com.empresa.API_empresa.funcionario.entities.FuncionarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados) {
        funcionarioService.cadastrarFuncionario(dados);
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.listarFuncionario();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody AtualizarDadosFuncionario dados){
        var funcionario = funcionarioService.carregarFuncionario(dados.id());
        funcionario.atualizarInformacoes(dados);
    }

}
