package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.entidades.Usuario;
import com.grupo4.integrador.servicios.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDAOH2Test {

    Paciente pac1 = new Paciente(1,"leonardo","spadavecchia", "savio 3270", "39427236", "2023-05-10");
    PacienteService ps = new PacienteService(new PacienteDAOH2());
    @BeforeEach
    void creartablas(){
        PacienteDAOH2.crearTablaPaciente();
    }
    @Test
    void registrar() {
        assertTrue(ps.registrar(pac1));
    }

    @Test
    void listar() {
    }
}