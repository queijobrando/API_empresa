package com.empresa.API_empresa.funcionario.entities;

import jakarta.validation.constraints.NotNull;

public record AtualizarDadosFuncionario(@NotNull Long id, String email) {
}
