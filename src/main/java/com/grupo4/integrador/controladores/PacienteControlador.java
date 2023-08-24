package com.grupo4.integrador.controladores;

import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteControlador {
    private PacienteService pacienteService;

    @Autowired
    public PacienteControlador(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Paciente> registarPaciente(@RequestBody Paciente paciente) {
        ResponseEntity res;
        Paciente nuevoPaciente = pacienteService.registrar(paciente);
        if (nuevoPaciente == null) {
            res = new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            res = new ResponseEntity(nuevoPaciente, HttpStatus.OK);
        }
        return res;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPaciente() {
        ResponseEntity res;
        List<Paciente> listPacientes = pacienteService.listar();
        if (listPacientes.size() == 0) {
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(listPacientes, HttpStatus.OK);
        }
        return res;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable int id) {
        ResponseEntity res;
        Paciente paciente = pacienteService.buscar(id);
        if (paciente == null) {
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        return res;
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable int id) {
        ResponseEntity res;
        if (pacienteService.buscar(id) == null) {
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            pacienteService.eliminar(id);
            res = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return res;
    }
}
