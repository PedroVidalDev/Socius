package com.pedro.socius.application.dtos.local;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLocal(
        @NotNull String nome,
        @NotNull Categoria categoria,
        @NotNull int qntMaxPessoas) {
}
