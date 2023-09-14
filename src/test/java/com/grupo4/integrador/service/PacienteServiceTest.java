package com.grupo4.integrador.service;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.dto.PacienteDto.ActualizarPacientoDto;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.entity.Paciente;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    @Autowired
    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Autowired
    public void setDomicilioService(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }

    @BeforeEach
    public void cargarData() throws Exception {
        CrearDomicilioDto domicilio = new CrearDomicilioDto();
        CrearPacienteDto pac = new CrearPacienteDto();
        pac.setNombre("mufasa");
        pac.setDni("11111");
        pac.setApellido("holmes");
        pac.setDomicilio(domicilio);
        pac.setFechaAlta(LocalDate.now());
        domicilioService.registrar(domicilio);
        pacienteService.registrar(pac);
    }

    @Test
    public void listarTodosLosPacientes() throws Exception {
        CrearDomicilioDto domicilio = new CrearDomicilioDto();
        CrearPacienteDto pac = new CrearPacienteDto();
        pac.setNombre("mufasa");
        pac.setDni("11111");
        pac.setApellido("holmes");
        pac.setDomicilio(domicilio);
        pac.setFechaAlta(LocalDate.now());
        domicilioService.registrar(domicilio);
        pacienteService.registrar(pac);
        List<Paciente> pacienteList = pacienteService.listar();
        System.out.println(pacienteList);
        Assert.assertTrue(pacienteList.size() > 0);
    }

    @Test
    public void agregarYBuscarPacienteTest() throws Exception {
        CrearDomicilioDto domicilio = new CrearDomicilioDto();
        CrearPacienteDto pac = new CrearPacienteDto();
        pac.setNombre("mufasa");
        pac.setDni("11111");
        pac.setApellido("holmes");
        pac.setDomicilio(domicilio);
        pac.setFechaAlta(LocalDate.now());

        Paciente p = pacienteService.registrar(pac);

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void actualizar() throws Exception {
        ActualizarPacientoDto pac = new ActualizarPacientoDto();
        DomicilioDto domicilio = new DomicilioDto(1L, "FALSA", "111", "QUILMES", "LA MATANZAA");
        pac.setId(1L);
        pac.setNombre("mufasa");
        pac.setDni("11111");
        pac.setApellido("holmes");
        pac.setDomicilio(domicilio);
        pac.setFechaAlta(LocalDate.now());

        Assert.assertNotNull(pacienteService.actualizarPaciente(pac));

    }

    @Test
    public void eliminarPacienteTest() throws Exception {

        try {
            pacienteService.eliminar(1L);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals(ResourceNotFoundException.class, e.getClass());
        }
    }
}