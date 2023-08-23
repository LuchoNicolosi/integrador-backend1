package com.grupo4.integrador.servicios;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Paciente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    IDao<Paciente> daoPaciente;

    public PacienteService(IDao<Paciente> daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public Paciente registrar(Paciente p) {
        return daoPaciente.registrar(p);
    }

    public List<Paciente> listar() {
        return daoPaciente.listar();
    }

    public Paciente buscar(int id) {
        return daoPaciente.buscar(id);
    }

    public void eliminar(int id) {
        daoPaciente.eliminar(id);
    }

}
