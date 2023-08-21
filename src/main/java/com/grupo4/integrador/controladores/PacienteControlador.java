package com.grupo4.integrador.controladores;

import com.grupo4.integrador.repositorio.implementaciones.PacienteDAOH2;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteControlador {
    private PacienteService pacienteService;

    @Autowired
    public PacienteControlador(PacienteService pacienteService) {
        PacienteDAOH2.crearTablaPaciente();
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listarPaciente() {
        return pacienteService.listar();
    }

    @PostMapping
    public Paciente registarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.registrar(paciente);
    }

}
