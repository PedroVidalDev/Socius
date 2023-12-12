package com.pedro.socius.application.dtos.socio;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record DadosRegistrarSocio(
        @NotBlank String nome,
        @NotBlank @CPF String cpf) {
}
