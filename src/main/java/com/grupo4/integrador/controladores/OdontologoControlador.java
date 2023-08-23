package com.grupo4.integrador.controladores;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.servicios.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private OdontologoService odontologoService;

    @Autowired
    public OdontologoControlador(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        ResponseEntity res;
        Odontologo nuevoOdontologo = odontologoService.registrar(odontologo);
        if (nuevoOdontologo == null) {
            res = new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            res = new ResponseEntity(nuevoOdontologo, HttpStatus.OK);
        }
        return res;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos() {
        ResponseEntity res;
        List<Odontologo> listOdontologos = odontologoService.listar();
        if (listOdontologos.size() == 0) {
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(listOdontologos, HttpStatus.OK);
        }
        return res;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> obtenerOdontologoPorId(@PathVariable int id) {
        ResponseEntity res;
        Odontologo odontologo = odontologoService.buscar(id);
        if (odontologo == null) {
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(odontologo, HttpStatus.OK);
        }
        return res;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarOdontologo(@PathVariable int id) {
        ResponseEntity res;
        if (odontologoService.buscar(id) == null) {
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            odontologoService.eliminar(id);
            res = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return res;
    }

}
