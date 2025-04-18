package com.empresa.API_empresa.funcionario.entities;

import com.empresa.API_empresa.endereco.DadosCadastroEndereco;
import com.empresa.API_empresa.funcionario.enums.Cargo;
import com.empresa.API_empresa.setor.entities.Setor;

public record DadosCadastroFuncionario(String nome, String email, Cargo cargo, Long idSetor, DadosCadastroEndereco endereco) {
}
