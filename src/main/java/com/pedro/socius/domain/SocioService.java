package com.pedro.socius.domain;

import com.pedro.socius.application.dtos.local.DadosDataSocioLocal;
import com.pedro.socius.application.dtos.socio.DadosRelatorioPorCategoriaSocio;
import com.pedro.socius.application.dtos.socio.DadosRelatorioSocio;
import com.pedro.socius.application.dtos.socio.DadosTempoPorCategoria;
import com.pedro.socius.infrastructure.entities.Agendamento;
import com.pedro.socius.infrastructure.entities.Local;
import com.pedro.socius.infrastructure.repositories.AgendamentoRepository;
import com.pedro.socius.infrastructure.repositories.LocalRepository;
import com.pedro.socius.infrastructure.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SocioService {
    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<DadosRelatorioSocio> realizarRelatorioPorSocio(Long id){
        var agendamentos = agendamentoRepository.findAllBySocioId(id);

        List<DadosRelatorioSocio> dados = new ArrayList<>();

        for(var element : agendamentos){
            DadosRelatorioSocio dado = new DadosRelatorioSocio(element.getSocio().getNome(), element.getLocal().getNome(), element.getDataInicio());
            dados.add(dado);
        }

        return dados;
    }

    public List<DadosRelatorioPorCategoriaSocio> realizarRelatorioDeSocioPorCategoria() {
        var socios = socioRepository.findAll();

        int horasEsportes;
        int horasRecreacao;
        int horasRelaxamento;

        List<DadosRelatorioPorCategoriaSocio> dados = new ArrayList<>();

        for(var element : socios){

            horasEsportes = 0;
            horasRecreacao = 0;
            horasRelaxamento = 0;

            var agendamentos = agendamentoRepository.findAllBySocioId(element.getId());

            for (var subelement : agendamentos){
                if(subelement.getLocal().getCategoria().toString().equals("ESPORTES")){
                    LocalTime horaInicio = LocalTime.parse(subelement.getDataInicio().getHour() + ":" + subelement.getDataInicio().getMinute());
                    LocalTime horaFim = LocalTime.parse(subelement.getDataFim().getHour() + ":" + subelement.getDataFim().getMinute());

                    horasEsportes = (int) (horasEsportes + Duration.between(horaInicio, horaFim).toHours());
                }

                else if(subelement.getLocal().getCategoria().toString().equals("RECRECAO")){
                    LocalTime horaInicio = LocalTime.parse(subelement.getDataInicio().getHour() + ":" + subelement.getDataInicio().getMinute());
                    LocalTime horaFim = LocalTime.parse(subelement.getDataFim().getHour() + ":" + subelement.getDataFim().getMinute());

                    horasRecreacao = (int) (horasRecreacao + Duration.between(horaInicio, horaFim).toHours());
                }

                else if(subelement.getLocal().getCategoria().toString().equals("RELAXAMENTO")){
                    LocalTime horaInicio = LocalTime.parse(subelement.getDataInicio().getHour() + ":" + subelement.getDataInicio().getMinute());
                    LocalTime horaFim = LocalTime.parse(subelement.getDataFim().getHour() + ":" + subelement.getDataFim().getMinute());

                    horasRelaxamento = (int) (horasRelaxamento + Duration.between(horaInicio, horaFim).toHours());
                }

            }

            DadosRelatorioPorCategoriaSocio dado = new DadosRelatorioPorCategoriaSocio(element.getNome(), new DadosTempoPorCategoria(horasEsportes, horasRecreacao, horasRelaxamento));

            dados.add(dado);
        }
        return dados;
    }
}
