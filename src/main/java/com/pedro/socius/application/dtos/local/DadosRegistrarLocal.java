package com.pedro.socius.application.dtos.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistrarLocal (
        @NotBlank String nome,
        @NotBlank Categoria categoria,
        @NotNull int qntMaxPessoas){
}
