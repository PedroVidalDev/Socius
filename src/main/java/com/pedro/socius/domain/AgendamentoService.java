package com.pedro.socius.domain;

import com.pedro.socius.application.dtos.agendamento.DadosRegistrarAgendamento;
import com.pedro.socius.infrastructure.entities.Agendamento;
import com.pedro.socius.infrastructure.repositories.AgendamentoRepository;
import com.pedro.socius.infrastructure.repositories.LocalRepository;
import com.pedro.socius.infrastructure.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class AgendamentoService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void verificarCriacaoAgendamento(DadosRegistrarAgendamento dados) {
        var local = localRepository.getReferenceById(dados.localId());
        var socio = socioRepository.getReferenceById(dados.socioId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        var dataInicio = LocalDateTime.parse(dados.dataInicio(), formatter);
        var dataFim = LocalDateTime.parse(dados.dataFim(), formatter);


        if(dataInicio.isAfter(LocalDateTime.now())){

            if(dataFim.isAfter(dataInicio) && dataFim.isBefore(dataInicio.plusDays(1))){

                if(dados.qntPessoas() <= local.getQntMaxPessoas()){

                    if(agendamentoRepository.existsByDataInicioBetween(dataInicio, dataFim)){
                        Agendamento agendamento = new Agendamento(null, local, socio, dados.qntPessoas(), dataInicio, dataFim);

                        agendamentoRepository.save(agendamento);
                    }
                    else{
                        throw new RuntimeException("Já existe um agendamento para esse dia e hora.");
                    }

                }

                else{
                    throw new RuntimeException("Qnt. de pessoas maior que o esperado.");
                }

            }
            else{
                throw new RuntimeException("Data invalida.");
            }

        }
        else{
            throw new RuntimeException("Data invalida.");
        }


    }
}
