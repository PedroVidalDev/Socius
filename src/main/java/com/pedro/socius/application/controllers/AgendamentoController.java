package com.pedro.socius.application.controllers;

import com.pedro.socius.application.dtos.agendamento.DadosRegistrarAgendamento;
import com.pedro.socius.domain.AgendamentoService;
import com.pedro.socius.infrastructure.repositories.AgendamentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosRegistrarAgendamento dados){
        service.verificarCriacaoAgendamento(dados);

        return ResponseEntity.ok().build();
    }

}
