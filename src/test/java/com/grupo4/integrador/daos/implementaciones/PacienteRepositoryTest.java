package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.implementaciones.PacienteRepository;
import com.grupo4.integrador.servicios.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PacienteRepositoryTest {

    //Paciente pac1 = new Paciente(1, "leonardo", "spadavecchia", "savio 3270", "39427236", "2023-05-10");
    PacienteService ps = new PacienteService(new PacienteRepository());

    @Test
    void registrar() {
        //Assertions.assertNotNull(ps.registrar(pac1));
    }

    @Test
    void listar() {
    }
}