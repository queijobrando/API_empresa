package com.empresa.API_empresa.setor.entities;

import com.empresa.API_empresa.setor.enums.Area;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroSetor(
        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        Area area) {
}
