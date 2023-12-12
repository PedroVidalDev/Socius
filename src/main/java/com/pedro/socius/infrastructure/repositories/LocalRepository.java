package com.pedro.socius.infrastructure.repositories;

import com.pedro.socius.infrastructure.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {
}
