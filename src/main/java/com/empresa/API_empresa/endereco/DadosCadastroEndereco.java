package com.empresa.API_empresa.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        String numero,

        String complemento,

        @NotBlank
        String cidade,
        @NotBlank
        String uf) {
}
