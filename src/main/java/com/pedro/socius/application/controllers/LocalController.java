package com.pedro.socius.application.controllers;

import com.pedro.socius.application.dtos.local.DadosAtualizarLocal;
import com.pedro.socius.application.dtos.local.DadosRegistrarLocal;
import com.pedro.socius.application.dtos.local.DadosResgatarLocal;
import com.pedro.socius.infrastructure.entities.Local;
import com.pedro.socius.infrastructure.repositories.LocalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locais")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DadosRegistrarLocal dados){
        Local local = new Local(dados);

        repository.save(local);

        return ResponseEntity.ok().build();
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
}
