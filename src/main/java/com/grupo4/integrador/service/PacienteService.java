package com.grupo4.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.dto.PacienteDto.ActualizarPacientoDto;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.entity.Domicilio;
import com.grupo4.integrador.entity.Paciente;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final DomicilioService domicilioService;
    private final ObjectMapper mapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, DomicilioService domicilioService, ObjectMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioService = domicilioService;
        this.mapper = mapper;
    }

    public Paciente registrar(CrearPacienteDto p) throws Exception {
        Paciente paciente;
        DomicilioDto dom = mapper.convertValue(p.getDomicilio(), DomicilioDto.class);
        paciente = mapper.convertValue(p, Paciente.class);
        paciente.setDomicilio(domicilioService.registrar(dom));
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Paciente buscar(Long id) throws ResourceNotFoundException {
        Optional<Paciente> p = pacienteRepository.findById(id);
        if (p.isEmpty()) {
            throw new ResourceNotFoundException(id.toString(), "No existe un paciente con el id -");
        }
        return p.get();
    }

    public void eliminar(Long id) throws ResourceNotFoundException {
        Paciente p = buscar(id);
        pacienteRepository.delete(p);
    }

    public Paciente actualizarPaciente(ActualizarPacientoDto actualizarPacientoDto) throws Exception {
        Paciente paciente = mapper.convertValue(actualizarPacientoDto, Paciente.class);
        domicilioService.registrar(actualizarPacientoDto.getDomicilio());
        return pacienteRepository.save(paciente);
    }

}
