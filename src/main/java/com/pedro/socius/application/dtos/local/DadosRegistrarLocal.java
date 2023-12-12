package com.pedro.socius.application.dtos.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistrarLocal (
        @NotBlank(message = "Nome nao deve ser nulo ou vazio.")
        String nome,

        @NotBlank(message = "Categoria nao deve ser nula ou vazia.")
        Categoria categoria,

        @NotNull(message = "Qnt. de pessoas nao deve ser nula ou vazia.")
        int qntMaxPessoas){
}
