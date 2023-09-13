package com.grupo4.integrador.service;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    void registrar() {
        CrearDomicilioDto domicilio = new CrearDomicilioDto("falsa", "123", "springfield", "siempre viva");
        CrearPacienteDto paciente = new CrearPacienteDto("Pepe", "garcia", "123454", LocalDate.now(), domicilio);
    }

    @Test
    void listar() {
    }

    @Test
    void buscar() {
    }

    @Test
    void eliminar() {
    }
}