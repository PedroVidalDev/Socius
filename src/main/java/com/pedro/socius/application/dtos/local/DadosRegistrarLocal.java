package com.pedro.socius.application.dtos.local;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistrarLocal (
        @NotBlank(message = "Nome nao deve ser nulo ou vazio.")
        String nome,

        @Enumerated
        Categoria categoria,

        @NotNull(message = "Qnt. de pessoas nao deve ser nula ou vazia.")
        @Min(value = 0, message = "Valor minimo é zero.")
        int qntMaxPessoas){
}
