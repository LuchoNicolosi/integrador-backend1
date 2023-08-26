package com.grupo4.integrador.controladores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.dto.OdontologoDto.OdontologoDto;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.servicios.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private final OdontologoService odontologoService;
    private final Logger LOGGER = Logger.getLogger(OdontologoControlador.class);

    @Autowired
    public OdontologoControlador(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<OdontologoDto> registrarOdontologo(@RequestBody CrearOdontologoDto odontologoDto) {
        ObjectMapper map = new ObjectMapper();
        Odontologo nuevoOdontologo;
        try {
            nuevoOdontologo = odontologoService.registrar(odontologoDto);
        } catch (Exception e) {
            LOGGER.info("No se puedo crear el odontologo. " + e);
            return ResponseEntity.badRequest().build();
        }
        LOGGER.info("Odontologo creado.");

        return new ResponseEntity<OdontologoDto>(map.convertValue(nuevoOdontologo, OdontologoDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OdontologoDto>> listarOdontologos() {
        ObjectMapper mapper = new ObjectMapper();
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
    public ResponseEntity<OdontologoDto> obtenerOdontologoPorId(@PathVariable int id) {
        ObjectMapper mapper = new ObjectMapper();
        Odontologo odontologo = odontologoService.buscar(id);
        if (odontologo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOGGER.info("odontologo encontrado.");
        return new ResponseEntity<>(mapper.convertValue(odontologo, OdontologoDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarOdontologo(@PathVariable int id) {
        ResponseEntity res;
        if (odontologoService.buscar(id) == null) {
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            odontologoService.eliminar(id);
            res = new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
        return res;
    }

}
