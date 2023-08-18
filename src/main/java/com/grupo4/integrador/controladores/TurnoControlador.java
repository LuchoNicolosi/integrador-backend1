package com.grupo4.integrador.controladores;

import com.grupo4.integrador.daos.implementaciones.TurnoDAOH2;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.servicios.TurnoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turno")
public class TurnoControlador {
    private static TurnoService turnoService = null;

    private TurnoService getTurnoService(){
        return turnoService == null ? turnoService = new TurnoService(new TurnoDAOH2()) : turnoService;
    }
    @GetMapping
    public List<Turno> listarTurno(){
        return turnoService.listar();
    }
}
