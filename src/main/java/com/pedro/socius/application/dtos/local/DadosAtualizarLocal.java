package com.pedro.socius.application.dtos.local;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLocal(
        @NotNull(message = "Nome nao deve ser vazio ou nulo.")
        String nome,
        @NotNull(message = "Categoria nao deve ser vazia ou nula.")
        Categoria categoria,
        @NotNull(message = "Qnt. de pessoas nao deve ser vazia ou nula.")
        int qntMaxPessoas) {
}
