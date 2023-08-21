package com.grupo4.integrador.controladores;

import com.grupo4.integrador.repositorio.implementaciones.OdontologoDAOH2;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.servicios.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private OdontologoService odontologoService;
    @Autowired
    public OdontologoControlador(OdontologoService odontologoService) {
        OdontologoDAOH2.crearTablaOdontologo();
        this.odontologoService = odontologoService;
    }
    @GetMapping
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listar();
    }
    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo o) {
        System.out.println(o);
        return odontologoService.registrar(o);
    }
}
