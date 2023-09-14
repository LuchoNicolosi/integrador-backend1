package com.grupo4.integrador.repository;

import com.grupo4.integrador.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
