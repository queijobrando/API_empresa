package com.empresa.API_empresa.controllers;

import com.empresa.API_empresa.setor.entities.DadosCadastroSetor;
import com.empresa.API_empresa.setor.entities.SetorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setor")
public class SetorController {

    private final SetorService setorService;

    @Autowired
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @PostMapping
    public String cadastrarSetor(@RequestBody @Valid DadosCadastroSetor dados){
        setorService.cadastrarSetor(dados);

        return "Setor adicionado com sucesso!";
    }
}
