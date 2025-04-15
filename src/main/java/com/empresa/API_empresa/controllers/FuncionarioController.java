package com.empresa.API_empresa.controllers;

import com.empresa.API_empresa.endereco.Endereco;
import com.empresa.API_empresa.funcionario.entities.DadosCadastroFuncionario;
import com.empresa.API_empresa.funcionario.entities.Funcionario;
import com.empresa.API_empresa.funcionario.entities.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    //injeção dependencia
    @Autowired
    private FuncionarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarFuncionario(@RequestBody DadosCadastroFuncionario dados){
        repository.save(new Funcionario(dados));
    }

}
