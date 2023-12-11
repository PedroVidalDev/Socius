package com.pedro.socius.infrastructure.repositories;

import com.pedro.socius.infrastructure.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
