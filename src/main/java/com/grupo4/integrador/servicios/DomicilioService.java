package com.grupo4.integrador.servicios;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.repositorio.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio registrar(Domicilio dom) throws Exception {
        return domicilioRepository.save(dom);
    }

//    public List<Domicilio> listar() {
//        return domicilioRepository.findAll();
//    }
//
//    public Domicilio buscar(Long id) {
//        return domicilioRepository.findById(id).get();
//    }
//
//    public void eliminar(Long id) {
//        domicilioRepository.deleteById(id);
//    }
}
