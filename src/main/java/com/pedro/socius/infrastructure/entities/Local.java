package com.pedro.socius.infrastructure.entities;

import com.google.gson.JsonArray;
import com.pedro.socius.application.dtos.local.Categoria;
import com.pedro.socius.application.dtos.local.DadosAtualizarLocal;
import com.pedro.socius.application.dtos.local.DadosRegistrarLocal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Array;

import java.time.LocalDateTime;

@Entity(name="Local")
@Table(name="locais")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")

public class Local {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private int qntMaxPessoas;
    private int qntHoras;
    private LocalDateTime dtcreate;
    private LocalDateTime dtupdate;

    // adicionar campo de lista de datas

    public Local(DadosRegistrarLocal dados){
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.qntMaxPessoas = dados.qntMaxPessoas();
        this.qntHoras = 0;
        this.dtcreate = LocalDateTime.now();
        this.dtupdate = null;
    }

    public void atualizar(DadosAtualizarLocal dados){
        String nomeAntigo = this.nome;
        Categoria categoriaAntiga = this.categoria;
        int qntMaxPessoasAntiga = this.qntMaxPessoas;

        if(!dados.nome().isBlank()){
            this.nome = dados.nome();
        }

        else if(!String.valueOf(dados.categoria()).isBlank()){
            this.categoria = dados.categoria();
        }

        else if(!String.valueOf(dados.qntMaxPessoas()).isBlank()){
            this.qntMaxPessoas = dados.qntMaxPessoas();
        }

        if(!nomeAntigo.equals(dados.nome()) || !categoriaAntiga.equals(dados.categoria()) || !(qntMaxPessoasAntiga == dados.qntMaxPessoas())){
            this.dtupdate = LocalDateTime.now();
        }
    }

}
