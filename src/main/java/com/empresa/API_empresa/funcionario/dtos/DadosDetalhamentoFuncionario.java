package com.empresa.API_empresa.funcionario.dtos;

import com.empresa.API_empresa.endereco.Endereco;
import com.empresa.API_empresa.funcionario.entities.Funcionario;
import com.empresa.API_empresa.funcionario.enums.Cargo;
import com.empresa.API_empresa.setor.entities.Setor;

public record DadosDetalhamentoFuncionario(Long id, String nome, String email, Cargo cargo, Setor setor) {
    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getEmail(), funcionario.getCargo(), funcionario.getSetor());
    }
}
