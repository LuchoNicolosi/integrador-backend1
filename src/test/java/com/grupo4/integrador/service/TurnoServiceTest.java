package com.grupo4.integrador.service;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.dto.OdontologoDto.ActualizarOdontologoDto;
import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.dto.TurnoDto.CrearTurnoDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.entity.Paciente;
import com.grupo4.integrador.entity.Turno;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.repository.OdontologoRepository;
import com.grupo4.integrador.repository.PacienteRepository;
import com.grupo4.integrador.repository.TurnoRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private DomicilioService domicilioService;

    @BeforeEach
    void cargaData() throws Exception {
        //Odontologo
        CrearOdontologoDto odontologoDto = new CrearOdontologoDto();
        odontologoDto.setNombre("leo");
        odontologoDto.setApellido("messi");
        odontologoDto.setMatricula("abc-1234");
        Odontologo odontologo = odontologoService.registrar(odontologoDto);
//Paciente
        CrearDomicilioDto domicilio = new CrearDomicilioDto();
        CrearPacienteDto pac = new CrearPacienteDto();
        pac.setNombre("mufasa");
        pac.setDni("11111");
        pac.setApellido("holmes");
        pac.setDomicilio(domicilio);
        pac.setFechaAlta(LocalDate.now());

        domicilioService.registrar(domicilio);
        Paciente paciente = pacienteService.registrar(pac);

//Turno
        CrearTurnoDto turnoDto = new CrearTurnoDto();
        turnoDto.setOdontologoId(odontologo.getId());
        turnoDto.setPacienteId(paciente.getId());
        turnoDto.setFecha(LocalDateTime.now());
        turnoService.registrar(turnoDto);


    }

    @Test
    void listar() {
        List<Turno> turnos = turnoService.listar();
//        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertFalse(turnos.isEmpty());
        System.out.println(turnos);
    }

    @Test
    void buscar() throws Exception {
        List<Turno> turnos = turnoService.listar();
        Turno t = turnos.get(0);
        Assert.assertNotNull(turnoService.buscar(t.getId()));
    }

    @Test
    void eliminar() {
        try {
            turnoService.eliminar(1L);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals(ResourceNotFoundException.class, e.getClass());
        }
    }

    @Test
    void modificar() throws Exception {
        Odontologo odontologo = odontologoService.buscar(1L);
        Paciente paciente = pacienteService.buscar(1L);
        Turno turno = turnoService.buscar(1L);
        CrearTurnoDto actualizarTurno = new CrearTurnoDto();
        actualizarTurno.setOdontologoId(odontologo.getId());
        actualizarTurno.setPacienteId(paciente.getId());
        actualizarTurno.setFecha(LocalDateTime.now());
        turnoService.registrar(actualizarTurno);
    }
}