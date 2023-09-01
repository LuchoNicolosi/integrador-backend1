package com.grupo4.integrador.service;

import com.grupo4.integrador.entity.Domicilio;
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
