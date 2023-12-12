package com.pedro.socius.application.dtos.socio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosAtualizarSocio(
         @NotNull String nome,
         @NotNull @CPF(message = "CPF deve ser valido.") String cpf) {
}
