package com.pedro.socius.application.dtos;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistrarSocio(
        @NotBlank String nome,
        @NotBlank String cpf) {
}
