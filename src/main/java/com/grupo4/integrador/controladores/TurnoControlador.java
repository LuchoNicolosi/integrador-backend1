package com.grupo4.integrador.controladores;

import com.grupo4.integrador.repositorio.implementaciones.TurnoDAOH2;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.servicios.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("turno")
public class TurnoControlador {
    private TurnoService turnoService;

    @Autowired
    public TurnoControlador(TurnoService turnoService) {
        TurnoDAOH2.crearTablaTurno();
        this.turnoService = turnoService;
    }

    @PostMapping
    public Turno crearTurno(@RequestBody Turno turno) {
        return turnoService.registrar(turno);
    }
}
