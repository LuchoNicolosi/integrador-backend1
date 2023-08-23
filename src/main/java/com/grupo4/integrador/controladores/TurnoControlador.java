package com.grupo4.integrador.controladores;

import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.entidades.servicios.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("turno")
public class TurnoControlador {
    private TurnoService turnoService;

    @Autowired
    public TurnoControlador(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno) {
        ResponseEntity res;
        if (turnoService.registrar(turno) == null) {
            res = new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            res = new ResponseEntity(turnoService.registrar(turno), HttpStatus.OK);
        }
        return res;
    }
}
