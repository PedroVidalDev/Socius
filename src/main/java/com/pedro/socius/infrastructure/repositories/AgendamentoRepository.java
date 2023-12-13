package com.pedro.socius.infrastructure.repositories;

import com.pedro.socius.infrastructure.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    boolean existsByDataInicioBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

    List<Agendamento> findAllByLocalId(Long id);
}
