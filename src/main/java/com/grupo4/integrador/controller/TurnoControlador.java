package com.grupo4.integrador.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.TurnoDto.ActualizarTurnoDto;
import com.grupo4.integrador.dto.TurnoDto.CrearTurnoDto;
import com.grupo4.integrador.dto.TurnoDto.TurnoDto;
import com.grupo4.integrador.entity.Turno;
import com.grupo4.integrador.exceptions.BadRequestException;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.service.TurnoService;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("turno")
public class TurnoControlador {
    private final TurnoService turnoService;
    private final ObjectMapper mapper;
    private final Logger LOGGER = Logger.getLogger(TurnoControlador.class);

    @Autowired
    public TurnoControlador(TurnoService turnoService, ObjectMapper mapper) {
        this.turnoService = turnoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TurnoDto> crearTurno(@Valid @RequestBody CrearTurnoDto turnoDTO) throws BadRequestException {
        Turno nuevoTurno;
        try {
            nuevoTurno = turnoService.registrar(turnoDTO);
        } catch (Exception e) {
            LOGGER.error("No se pudo crear el turno");
            throw new BadRequestException(e.getMessage());
        }
        LOGGER.info("Se pudo crear el turno");
        System.out.println(nuevoTurno.getFecha());
        return new ResponseEntity<>(mapper.convertValue(nuevoTurno, TurnoDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TurnoDto>> listarTurnos() {
        List<TurnoDto> turnoDtoList;
        try {
            turnoDtoList = mapper.convertValue(turnoService.listar(), new TypeReference<>() {
            });
        } catch (Exception e) {
            LOGGER.error("error al listar los turnos", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        LOGGER.info("listando turnos" + turnoDtoList);
        return new ResponseEntity<>(turnoDtoList, HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<TurnoDto> modificarTurno(@Valid @RequestBody ActualizarTurnoDto turnoDTO, @RequestParam(name = "id") Long id) {
        Turno updateTurno;
        try {
            turnoDTO.setId(id);
            updateTurno = turnoService.modificar(turnoDTO);
        } catch (Exception e) {
            LOGGER.error("No se pudo actualizar el turno");
            return ResponseEntity.badRequest().build();
        }
        LOGGER.info("Se pudo crear el turno");
        return new ResponseEntity<>(mapper.convertValue(updateTurno, TurnoDto.class), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TurnoDto> buscarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Turno turno = turnoService.buscar(id);
        return new ResponseEntity<>(mapper.convertValue(turno, TurnoDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
