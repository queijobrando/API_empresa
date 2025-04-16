package com.empresa.API_empresa.controllers;

import com.empresa.API_empresa.funcionario.entities.DadosCadastroFuncionario;
import com.empresa.API_empresa.funcionario.entities.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public void cadastrarFuncionario(@RequestBody DadosCadastroFuncionario dados) {
        funcionarioService.cadastrarFuncionario(dados);
    }

}
