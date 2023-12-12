package com.pedro.socius.infrastructure.entities;

import com.pedro.socius.application.dtos.local.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Array;

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

    private Array listaDatasAgendadas;

}
