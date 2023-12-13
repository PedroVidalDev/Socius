package com.pedro.socius.application.controllers;

import com.pedro.socius.application.dtos.agendamento.DadosRegistrarAgendamento;
import com.pedro.socius.application.dtos.agendamento.DadosResgatarAgendamento;
import com.pedro.socius.domain.AgendamentoService;
import com.pedro.socius.infrastructure.entities.Agendamento;
import com.pedro.socius.infrastructure.repositories.AgendamentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @Autowired
    private AgendamentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosRegistrarAgendamento dados, UriComponentsBuilder uriBuild){
        Agendamento agendamento = service.verificarCriacaoAgendamento(dados);

        var uri = uriBuild.path("/agendamentos/{id}").buildAndExpand(agendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosResgatarAgendamento(agendamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable String id){
        repository.deleteById(Long.parseLong(id));

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity resgatar(@PathVariable String id){
        var agendamento = repository.getReferenceById(Long.parseLong(id));

        return ResponseEntity.ok(new DadosResgatarAgendamento(agendamento));
    }

}
