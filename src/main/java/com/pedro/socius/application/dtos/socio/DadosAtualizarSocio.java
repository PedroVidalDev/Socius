package com.pedro.socius.application.dtos.socio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosAtualizarSocio(
         @NotNull(message = "Nome nao deve ser vazio ou nulo.")
         String nome,

         @NotNull(message = "CPF nao deve ser vazio ou nulo.")
         @CPF(message = "CPF deve ser valido.") String cpf) {
}
