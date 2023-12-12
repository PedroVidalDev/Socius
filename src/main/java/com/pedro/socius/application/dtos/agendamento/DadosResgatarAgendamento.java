package com.pedro.socius.application.dtos.agendamento;

import com.pedro.socius.application.dtos.local.DadosResgatarLocal;
import com.pedro.socius.application.dtos.socio.DadosResgatarSocio;
import com.pedro.socius.infrastructure.entities.Agendamento;
import com.pedro.socius.infrastructure.entities.Local;
import com.pedro.socius.infrastructure.entities.Socio;

import java.time.LocalDateTime;

public record DadosResgatarAgendamento (Long id, DadosResgatarLocal local, DadosResgatarSocio socio, LocalDateTime dataInicio, LocalDateTime dataFim){
    public DadosResgatarAgendamento(Agendamento dados){
        this(dados.getId(), new DadosResgatarLocal(dados.getLocal()), new DadosResgatarSocio(dados.getSocio()), dados.getDataInicio(), dados.getDataFim());
    }
}
