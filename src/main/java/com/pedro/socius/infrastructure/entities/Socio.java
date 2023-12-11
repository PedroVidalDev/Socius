package com.pedro.socius.infrastructure.entities;

import com.pedro.socius.application.dtos.DadosRegistrarSocio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Socio(DadosRegistrarSocio dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
    }
}
