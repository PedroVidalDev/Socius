package com.pedro.socius.application.controllers;

import com.pedro.socius.application.dtos.local.DadosAtualizarLocal;
import com.pedro.socius.application.dtos.local.DadosRegistrarLocal;
import com.pedro.socius.application.dtos.local.DadosResgatarLocal;
import com.pedro.socius.domain.LocalService;
import com.pedro.socius.infrastructure.entities.Local;
import com.pedro.socius.infrastructure.repositories.LocalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("locais")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @Autowired
    private LocalService service;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DadosRegistrarLocal dados, UriComponentsBuilder uriBuild){
        Local local = new Local(dados);

        repository.save(local);

        var uri = uriBuild.path("/locais/{id}").buildAndExpand(local.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosResgatarLocal(local));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable String id, @RequestBody @Valid DadosAtualizarLocal dados){
        var local = repository.getReferenceById(Long.parseLong(id));

        local.atualizar(dados);

        return ResponseEntity.ok(new DadosResgatarLocal(local));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable String id){
        repository.deleteById(Long.parseLong(id));

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity resgatar(@PathVariable String id){
        var local = repository.getReferenceById(Long.parseLong(id));

        return ResponseEntity.ok(new DadosResgatarLocal(local));
    }

    @GetMapping("/relatorio/{id}")
    public ResponseEntity relatorioLocal(@PathVariable String id){
        var relatorio = service.realizarRelatorioPorLocal(Long.parseLong(id));

        return ResponseEntity.ok(relatorio);
    }
}
