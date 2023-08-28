package com.grupo4.integrador.servicios;

import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final IRepository<Paciente> pacienteRepository;

    public PacienteService(IRepository<Paciente> pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente registrar(CrearPacienteDto p) {
        Paciente paciente = new Paciente();
        paciente.setNombre(p.getNombre());
        paciente.setApellido(p.getApellido());
        paciente.setDni(p.getDni());
        paciente.setFechaAlta(p.getFechaAlta());

        return pacienteRepository.registrar(paciente);
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