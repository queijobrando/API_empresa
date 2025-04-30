package com.empresa.API_empresa.funcionario.dtos;

import com.empresa.API_empresa.endereco.DadosCadastroEndereco;
import com.empresa.API_empresa.funcionario.enums.Cargo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotNull
        Cargo cargo,

        @NotNull
        Long idSetor,

        @NotNull
        @Valid
        DadosCadastroEndereco endereco) {
}
