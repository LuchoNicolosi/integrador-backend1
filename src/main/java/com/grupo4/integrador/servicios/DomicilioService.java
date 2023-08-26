package com.grupo4.integrador.servicios;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    private final IRepository<Domicilio> domicilioRepository;
    private final IRepository<Paciente> pacienteIRepository;

    public DomicilioService(IRepository<Domicilio> domicilioRepository, IRepository<Paciente> pacienteIRepository) {
        this.domicilioRepository = domicilioRepository;
        this.pacienteIRepository = pacienteIRepository;
    }

    public Domicilio registrar(CrearDomicilioDto dom) throws Exception {
        Domicilio domicilio = new Domicilio();
        Paciente paciente = pacienteIRepository.buscar(dom.getPaciente_id());
        if (paciente == null) throw new Exception("No paciente encontrado");

        domicilio.setPaciente(paciente);
        domicilio.setCalle(dom.getCalle());
        domicilio.setNumero(dom.getNumero());
        domicilio.setLocalidad(dom.getLocalidad());
        domicilio.setProvincia(dom.getProvincia());

        return domicilioRepository.registrar(domicilio);
    }

    public List<Domicilio> listar() {
        return domicilioRepository.listar();
    }

    public Domicilio buscar(int paciente_id) {
        return domicilioRepository.buscar(paciente_id);
    }

    public void eliminar(int paciente_id) {
        domicilioRepository.eliminar(paciente_id);
    }
}
