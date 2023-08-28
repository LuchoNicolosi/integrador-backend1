package com.grupo4.integrador.controladores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.TurnoDto.CrearTurnoDto;
import com.grupo4.integrador.dto.TurnoDto.TurnoDto;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.servicios.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turno")
public class TurnoControlador {
    private final TurnoService turnoService;
    private final Logger LOGGER = Logger.getLogger(TurnoControlador.class);

    @Autowired
    public TurnoControlador(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<TurnoDto> crearTurno(@RequestBody CrearTurnoDto turnoDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Turno nuevoTurno;
        try {
            nuevoTurno = turnoService.registrar(turnoDTO);
        } catch (Exception e) {
            LOGGER.error("No se pudo crear el turno");
            return ResponseEntity.badRequest().build();
        }
        LOGGER.info("Se pudo crear el turno");
        return new ResponseEntity<>(mapper.convertValue(nuevoTurno, TurnoDto.class), HttpStatus.OK);
    }


}
