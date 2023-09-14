package com.grupo4.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.entity.Domicilio;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio registrar(CrearDomicilioDto dom) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return domicilioRepository.save(mapper.convertValue(dom, Domicilio.class));
    }

    //    public List<Domicilio> listar() {
//        return domicilioRepository.findAll();
//    }
//
    public Domicilio buscar(Long id) {
        return domicilioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString(), "Domicilio not found"));
    }
//
//    public void eliminar(Long id) {
//        domicilioRepository.deleteById(id);
//    }
}
