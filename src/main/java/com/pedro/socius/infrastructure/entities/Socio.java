package com.pedro.socius.infrastructure.entities;

import com.pedro.socius.application.dtos.DadosRegistrarSocio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name="socios")
@Entity(name="Socio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Socio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private LocalDateTime dtcreate;
    private LocalDateTime dtupdate;

    public Socio(DadosRegistrarSocio dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dtcreate = LocalDateTime.now();
        this.dtupdate = null;
    }

    public void atualizarDados(DadosRegistrarSocio dados){
        if(!this.nome.equals(dados.nome()) || !this.cpf){
            this.dtupdate = LocalDateTime.now();
        }

        this.nome = dados.nome();
        this.cpf = dados.cpf();

    }
}
