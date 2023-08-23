package com.grupo4.integrador.entidades.servicios;

import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    IRepository<Paciente> daoPaciente;

    public PacienteService(IRepository<Paciente> daoPaciente) {
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
