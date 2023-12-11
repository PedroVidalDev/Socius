package com.pedro.socius.application.dtos;

import com.pedro.socius.infrastructure.entities.Socio;

import java.time.LocalDateTime;

public record DadosResgatarSocio (Long id, String nome, String cpf, LocalDateTime dtcreate, LocalDateTime dtupdate){
    public DadosResgatarSocio(Socio dados){
        this(dados.getId(), dados.getNome(), dados.getCpf(), dados.getDtcreate(), dados.getDtupdate());
    }
}
