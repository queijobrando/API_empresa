package com.empresa.API_empresa.funcionario.entities;

import com.empresa.API_empresa.endereco.DadosCadastroEndereco;
import com.empresa.API_empresa.endereco.Endereco;
import com.empresa.API_empresa.funcionario.enums.Cargo;
import com.empresa.API_empresa.setor.entities.Setor;
import jakarta.persistence.Entity;

@Entity
public class Funcionario {
    private Long id;
    private String nome;
    private String email;
    private Cargo cargo;
    private Endereco endereco;
    private Setor setor;
}
