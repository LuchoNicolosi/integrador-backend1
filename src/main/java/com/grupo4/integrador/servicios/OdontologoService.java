package com.grupo4.integrador.servicios;

import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IRepository<Odontologo> odontologoRepository;

    public OdontologoService(IRepository<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo registrar(Odontologo o) {
        return odontologoRepository.registrar(o);
    }

    public List<Odontologo> listar() {
        return odontologoRepository.listar();
    }

    public Odontologo buscar(int id) {
        return odontologoRepository.buscar(id);
    }

    public void eliminar(int id) {
        odontologoRepository.eliminar(id);
    }

}
