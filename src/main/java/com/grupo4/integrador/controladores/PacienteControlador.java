package com.grupo4.integrador.controladores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.dto.PacienteDto.PacienteDto;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.servicios.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteControlador {
    private final PacienteService pacienteService;
    private final Logger LOGGER = Logger.getLogger(PacienteControlador.class);

    @Autowired
    public PacienteControlador(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<PacienteDto> registarPaciente(@RequestBody CrearPacienteDto pacienteDto) {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente;
        try {
            paciente = pacienteService.registrar(pacienteDto);
        } catch (Exception e) {
            LOGGER.error("Error al crear al paciente");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("Paciente creado!");

        return new ResponseEntity<>(mapper.convertValue(paciente, PacienteDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> listarPaciente() {
        ObjectMapper mapper = new ObjectMapper();
        List<PacienteDto> listPacientes;
        try {
            listPacientes = mapper.convertValue(pacienteService.listar(), new TypeReference<>() {
            });
        } catch (Exception e) {
            LOGGER.error("Error listando pacientes. " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listPacientes, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PacienteDto> obtenerPacientePorId(@PathVariable int id) {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = pacienteService.buscar(id);
        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mapper.convertValue(paciente, PacienteDto.class), HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable int id) {
        if (pacienteService.buscar(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pacienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
