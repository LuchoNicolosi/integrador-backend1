package com.grupo4.integrador.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.PacienteDto.CrearPacienteDto;
import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.PacienteRepository;
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
        Domicilio dom = mapper.convertValue(p.getDomicilio(), Domicilio.class);
        paciente =  mapper.convertValue(p, Paciente.class);
        paciente.setDomicilio(domicilioService.registrar(dom));
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Paciente buscar(Long id) {
        Optional<Paciente> o = pacienteRepository.findById(id);
        return o.orElse(null);
    }

    public void eliminar(Long id) {
        Optional<Paciente> o = pacienteRepository.findById(id);
        o.ifPresent(pacienteRepository::delete);
    }

}
