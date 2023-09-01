package com.grupo4.integrador.repository;

import com.grupo4.integrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
