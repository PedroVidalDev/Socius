package com.pedro.socius.application.dtos.socio;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ResourceBundle;

public record DadosRegistrarSocio(
        @NotBlank(message = "Nome nao deve ser nulo ou vazio.")
        String nome,
        @NotBlank(message = "CPF nao deve ser nulo ou vazio.")
        @CPF(message = "CPF deve ser valido.")
        String cpf) {
}
