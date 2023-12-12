package com.pedro.socius.application.dtos.agendamento;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosRegistrarAgendamento(
        @NotNull(message = "ID do local deve ser preenchido.")
        Long localId,
        @NotNull(message = "ID do socio deve ser preenchido.")
        Long socioId,
        @NotNull(message = "Qnt. de pessoas deve ser preenchido")
        @Min(value = 0, message = "Qnt. de pessoas deve ser maior que 0.")
        int qntPessoas,
        @NotBlank(message = "Data de inicio deve ser preenchida.")
        String dataInicio,
        @NotBlank(message = "Data de fim deve ser preenchida.")
        String dataFim
) {
}
