package com.grupo4.integrador.servicios;

import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    IRepository<Paciente> pacienteRepository;

    public PacienteService(IRepository<Paciente> pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente registrar(Paciente p) {
        return pacienteRepository.registrar(p);
    }

    public List<Paciente> listar() {
        return pacienteRepository.listar();
    }

    public Paciente buscar(int id) {
        return pacienteRepository.buscar(id);
    }

    public void eliminar(int id) {
        pacienteRepository.eliminar(id);
    }

}
