package com.grupo4.integrador.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.dto.OdontologoDto.OdontologoDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.entity.Paciente;
import com.grupo4.integrador.exceptions.BadRequestException;
import com.grupo4.integrador.exceptions.InternalServerException;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.service.OdontologoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.apache.log4j.Logger;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private final OdontologoService odontologoService;
    private final ObjectMapper mapper;
    private final Logger LOGGER = Logger.getLogger(OdontologoControlador.class);

    @Autowired
    public OdontologoControlador(OdontologoService odontologoService, ObjectMapper mapper) {
        this.odontologoService = odontologoService;
        this.mapper = mapper;
    }


    @PostMapping("/registrar")
    public ResponseEntity<OdontologoDto> registrarOdontologo(@Valid @RequestBody CrearOdontologoDto odontologoDto) throws BadRequestException {
        Odontologo odontologo = null;
        try {
            odontologo = odontologoService.registrar(odontologoDto);
        } catch (Exception e) {
            LOGGER.error("Error al crear al odontologo");
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<OdontologoDto>(mapper.convertValue(odontologo, OdontologoDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OdontologoDto>> listarOdontologos() {
        List<OdontologoDto> listOdontologos;
        try {
            listOdontologos = mapper.convertValue(odontologoService.listar(), new TypeReference<List<OdontologoDto>>() {
            });
        } catch (Exception e) {
            LOGGER.error("Error en convertir odontologos");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOGGER.info("Listado de odontologos");
        return new ResponseEntity<>(listOdontologos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OdontologoDto> obtenerOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoService.buscar(id);
        LOGGER.info("odontologo encontrado.");
        return new ResponseEntity<>(mapper.convertValue(odontologo, OdontologoDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.ok("Registro eliminado");
    }

}
