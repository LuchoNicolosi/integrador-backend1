package com.grupo4.integrador.controladores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.dto.PacienteDto.PacienteDto;
import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.servicios.DomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente/domicilio")
public class DomicilioControlador {
    private final DomicilioService domicilioService;
    private final Logger LOGGER = Logger.getLogger(PacienteControlador.class);

    @Autowired
    public DomicilioControlador(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<DomicilioDto> registarDomicilio(@RequestBody CrearDomicilioDto domicilioDto) {
        ObjectMapper mapper = new ObjectMapper();
        Domicilio domicilio;
        try {
            domicilio = domicilioService.registrar(domicilioDto);
        } catch (Exception e) {
            LOGGER.error("Error al crear el domicilio");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("Domicilio creado!");

        return new ResponseEntity<>(mapper.convertValue(domicilio, DomicilioDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DomicilioDto>> listarDomicilio() {
        ObjectMapper mapper = new ObjectMapper();
        List<DomicilioDto> listDomicilios;
        try {
            listDomicilios = mapper.convertValue(domicilioService.listar(), new TypeReference<List<DomicilioDto>>() {
            });
        } catch (Exception e) {
            LOGGER.error("Error listando domicilios. " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listDomicilios, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DomicilioDto> obtenerDomicilioPorPacienteID(@PathVariable int id) {
        ObjectMapper mapper = new ObjectMapper();
        Domicilio domicilio = domicilioService.buscar(id);
        if (domicilio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mapper.convertValue(domicilio, DomicilioDto.class), HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarDomicilio(@PathVariable int id) {
        if (domicilioService.buscar(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        domicilioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
