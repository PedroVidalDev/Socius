package com.pedro.socius.application.dtos.socio;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record DadosAtualizarSocio(
         String nome,
         @CPF String cpf) {
}
