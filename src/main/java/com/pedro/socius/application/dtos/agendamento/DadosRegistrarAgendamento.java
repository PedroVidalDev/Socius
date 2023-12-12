package com.pedro.socius.application.dtos.agendamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosRegistrarAgendamento(
        @NotNull(message = "ID do local deve ser preenchido.")
        Long localId,
        @NotNull(message = "ID do socio deve ser preenchido.")
        Long socioId,
        @NotBlank(message = "Data de inicio deve ser preenchida.")
        String dataInicio,
        @NotBlank(message = "Data de fim deve ser preenchida.")
        String dataFim
) {
}
