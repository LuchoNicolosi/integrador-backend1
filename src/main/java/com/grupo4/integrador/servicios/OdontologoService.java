package com.grupo4.integrador.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.repositorio.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;
    private final ObjectMapper mapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository, ObjectMapper mapper) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = mapper;
    }


    public Odontologo registrar(CrearOdontologoDto o) {
        Odontologo odontologo= mapper.convertValue(o,Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Odontologo buscar(Long id) {
        Optional<Odontologo> o = odontologoRepository.findById(id);
        return o.orElse(null);
    }

    public void eliminar(Long id) {
        Optional<Odontologo> o = odontologoRepository.findById(id);
        o.ifPresent(odontologoRepository::delete);
    }

}
