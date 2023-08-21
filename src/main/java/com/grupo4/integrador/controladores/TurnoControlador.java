package com.grupo4.integrador.controladores;

import com.grupo4.integrador.daos.implementaciones.TurnoDAOH2;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.servicios.TurnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turno")
public class TurnoControlador {
    private static TurnoService turnoService = null;

    private TurnoService getTurnoService() {
        if (turnoService == null){
            TurnoDAOH2.crearTablaTurno();
            turnoService = new TurnoService(new TurnoDAOH2());
        }
        return turnoService;
    }

    @PostMapping
    public Turno crearTurno(@RequestBody Turno turno) {
        return getTurnoService().registrar(turno);
    }
}
