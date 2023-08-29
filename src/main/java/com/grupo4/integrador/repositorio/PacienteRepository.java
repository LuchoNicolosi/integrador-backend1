package com.grupo4.integrador.repositorio;

import com.grupo4.integrador.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
