package com.pedro.socius.application.dtos.local;

import com.pedro.socius.infrastructure.entities.Local;

import java.time.LocalDateTime;

public record DadosResgatarLocal(Long id, String nome, Categoria categoria, int qntMaxPessoas, float qntHoras, LocalDateTime dtcreate, LocalDateTime dtupdate) {
    public DadosResgatarLocal(Local dados){
        this(dados.getId(), dados.getNome(), dados.getCategoria(), dados.getQntMaxPessoas(), dados.getQntHoras(), dados.getDtcreate(), dados.getDtupdate());
    }
}
