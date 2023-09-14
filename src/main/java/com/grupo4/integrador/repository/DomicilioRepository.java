package com.grupo4.integrador.repository;

import com.grupo4.integrador.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
