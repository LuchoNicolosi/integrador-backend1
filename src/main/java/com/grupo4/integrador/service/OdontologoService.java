package com.grupo4.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo4.integrador.dto.OdontologoDto.ActualizarOdontologoDto;
import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.exceptions.BadRequestException;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.repository.OdontologoRepository;
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


    public Odontologo registrar(CrearOdontologoDto o) throws BadRequestException {
        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Odontologo buscar(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> o = odontologoRepository.findById(id);
        if (o.isEmpty()) {
            throw new ResourceNotFoundException(id.toString(),"Odontologo no encontrado");
        }
        return o.get();
    }

    public void eliminar(Long id) throws ResourceNotFoundException {
        Odontologo o = buscar(id);
        odontologoRepository.delete(o);
    }
    public Odontologo actualizarOdontologo(ActualizarOdontologoDto actualizarOdontologoDto){
        Odontologo odontologo = mapper.convertValue(actualizarOdontologoDto, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

}
