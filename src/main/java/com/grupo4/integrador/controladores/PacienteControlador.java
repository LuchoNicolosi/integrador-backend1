package com.grupo4.integrador.controladores;

import com.grupo4.integrador.daos.implementaciones.OdontologoDAOH2;
import com.grupo4.integrador.daos.implementaciones.PacienteDAOH2;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.servicios.OdontologoService;
import com.grupo4.integrador.servicios.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteControlador {
    private static PacienteService pacienteService = null;

    private PacienteService getService() {
        if (pacienteService == null) {
            pacienteService = new PacienteService(new PacienteDAOH2());
        }
        return pacienteService;
    }


    @GetMapping
    public List<Paciente> listarPaciente() {
        return getService().listar();
    }
    @PostMapping
    public boolean registarPaciente(@RequestBody Paciente paciente){
        return getService().registrar(paciente);
    }

}
