package com.pedro.socius.application.dtos.socio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosRelatorioSocio(String nome, String local, LocalDateTime data) {
}
