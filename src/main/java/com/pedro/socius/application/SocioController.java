package com.pedro.socius.application;

import com.pedro.socius.application.dtos.DadosRegistrarSocio;
import com.pedro.socius.infrastructure.entities.Socio;
import com.pedro.socius.infrastructure.repositories.SocioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("socios")
public class SocioController {

    @Autowired
    private SocioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DadosRegistrarSocio dados){
        Socio socio = new Socio(dados);

        repository.save(socio);

        return ResponseEntity.ok().build();

    }
}
