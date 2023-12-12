package com.pedro.socius.infrastructure.entities;

import com.pedro.socius.application.dtos.agendamento.DadosRegistrarAgendamento;
import com.pedro.socius.infrastructure.repositories.SocioRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Table(name = "agendamentos")
@Entity(name = "Agendamento")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Agendamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socio_id")
    private Socio socio;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

}
