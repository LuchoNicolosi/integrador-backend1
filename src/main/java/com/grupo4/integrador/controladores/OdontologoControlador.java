package com.grupo4.integrador.controladores;

import com.grupo4.integrador.daos.implementaciones.OdontologoDAOH2;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.servicios.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private static OdontologoService odontologoService = null;

    private OdontologoService getService() {
        if (odontologoService == null) {
            OdontologoDAOH2.crearTablaOdontologo();
            odontologoService = new OdontologoService(new OdontologoDAOH2());
        }
        return odontologoService;
    }

    @GetMapping
    public List<Odontologo> listarOdontologos() {
        return getService().listar();
    }

    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo o) {
        System.out.println(o);
        return getService().registrar(o);
    }
}
