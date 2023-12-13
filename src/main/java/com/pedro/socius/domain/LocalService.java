package com.pedro.socius.domain;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pedro.socius.application.dtos.agendamento.DadosResgatarAgendamento;
import com.pedro.socius.application.dtos.local.DadosDataSocioLocal;
import com.pedro.socius.application.dtos.local.DadosRelatorioLocal;
import com.pedro.socius.application.dtos.local.DadosResgatarLocal;
import com.pedro.socius.infrastructure.repositories.AgendamentoRepository;
import com.pedro.socius.infrastructure.repositories.LocalRepository;
import com.pedro.socius.infrastructure.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocalService {
    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public DadosRelatorioLocal realizarRelatorioPorLocal(Long id){
        var local = localRepository.getReferenceById(id);
        var agendamentos = agendamentoRepository.findAllByLocalId(id);

        int qntHoras = 0;
        List<DadosDataSocioLocal> datas = new ArrayList<>();

        for(var element : agendamentos){
            LocalTime horaInicio = LocalTime.parse(element.getDataInicio().getHour() + ":" + element.getDataInicio().getMinute());
            LocalTime horaFim = LocalTime.parse(element.getDataFim().getHour() + ":" + element.getDataFim().getMinute());

            datas.add(new DadosDataSocioLocal(element.getSocio().getNome(), element.getDataInicio()));

            qntHoras = (int) (qntHoras + Duration.between(horaInicio, horaFim).toHours());
        }

        DadosRelatorioLocal dados = new DadosRelatorioLocal(local.getNome(), qntHoras, datas);
        return dados;
    }
}
