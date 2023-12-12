package com.pedro.socius.application.controllers;

import com.pedro.socius.application.dtos.socio.DadosAtualizarSocio;
import com.pedro.socius.application.dtos.socio.DadosRegistrarSocio;
import com.pedro.socius.application.dtos.socio.DadosResgatarSocio;
import com.pedro.socius.infrastructure.entities.Socio;
import com.pedro.socius.infrastructure.repositories.SocioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("socios")
public class SocioController {

    @Autowired
    private SocioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DadosRegistrarSocio dados, UriComponentsBuilder uriBuild){
        Socio socio = new Socio(dados);

        repository.save(socio);

        var uri = uriBuild.path("/socios/{id}").buildAndExpand(socio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosResgatarSocio(socio));

    }

    @GetMapping("/{id}")
    public ResponseEntity resgatar(@PathVariable String id){
        Socio socio = repository.getReferenceById(Long.parseLong(id));

        DadosResgatarSocio dto = new DadosResgatarSocio(socio);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable String id){
        repository.deleteById(Long.parseLong(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editar(@PathVariable String id, @RequestBody @Valid DadosAtualizarSocio dados){
        var socio = repository.getReferenceById(Long.parseLong(id));

        socio.atualizarDados(dados);

        return ResponseEntity.ok(new DadosResgatarSocio(socio));
    }
}
