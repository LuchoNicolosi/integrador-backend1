package com.grupo4.integrador.repository;

import com.grupo4.integrador.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
