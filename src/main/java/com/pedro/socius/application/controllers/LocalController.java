package com.pedro.socius.application.controllers;

import com.pedro.socius.application.dtos.local.DadosRegistrarLocal;
import com.pedro.socius.infrastructure.entities.Local;
import com.pedro.socius.infrastructure.repositories.LocalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locais")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody DadosRegistrarLocal dados){
        Local local = new Local(dados);

        repository.save(local);

        return ResponseEntity.ok().build();
    }
}
