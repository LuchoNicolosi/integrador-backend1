package com.grupo4.integrador.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.OdontologoDto.OdontologoDto;
import com.grupo4.integrador.dto.PacienteDto.ActualizarPacientoDto;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.dto.PacienteDto.PacienteDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.entity.Paciente;
import com.grupo4.integrador.exceptions.BadRequestException;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.service.PacienteService;
import jakarta.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("paciente")
public class PacienteControlador {
    private final PacienteService pacienteService;
    private final ObjectMapper mapper;
    private final Logger LOGGER = Logger.getLogger(PacienteControlador.class);

    @Autowired
    public PacienteControlador(PacienteService pacienteService, ObjectMapper mapper) {
        this.pacienteService = pacienteService;
        this.mapper = mapper;
    }

    @PostMapping("/registrar")
    public ResponseEntity<PacienteDto> registarPaciente(@Valid @RequestBody CrearPacienteDto pacienteDto) throws BadRequestException {
        Paciente paciente;
        try {
            paciente = pacienteService.registrar(pacienteDto);
        } catch (Exception e) {
            LOGGER.error("Error al crear al paciente");
            throw new BadRequestException(e.getMessage());
        }
        LOGGER.info("Paciente creado!");
        return new ResponseEntity<>(mapper.convertValue(paciente, PacienteDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> listarPaciente() {
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

    @GetMapping("/buscar")
    public ResponseEntity<PacienteDto> obtenerPacientePorId(@RequestParam(name = "id") Long id) throws ResourceNotFoundException {
        Paciente paciente = pacienteService.buscar(id);
        return new ResponseEntity<>(mapper.convertValue(paciente, PacienteDto.class), HttpStatus.OK);
    }


    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarPaciente(@RequestParam(name = "id") Long id) throws ResourceNotFoundException {
        pacienteService.eliminar(id);
        return ResponseEntity.ok("Registro eliminado");
    }

    @PutMapping("/modificar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody ActualizarPacientoDto actualizarPacientoDto, @RequestParam(name = "pacId") Long pacienteId, @RequestParam("domId") int domicilioId) throws Exception {
        Paciente paciente = pacienteService.buscar(pacienteId);
        ResponseEntity<PacienteDto> response;
        PacienteDto pacienteDto = null;

        if (paciente != null) {
            actualizarPacientoDto.setId(pacienteId);
            actualizarPacientoDto.getDomicilio().setId(domicilioId);
            pacienteDto = mapper.convertValue(pacienteService.actualizarPaciente(actualizarPacientoDto), PacienteDto.class);
            response = new ResponseEntity<>(pacienteDto, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
