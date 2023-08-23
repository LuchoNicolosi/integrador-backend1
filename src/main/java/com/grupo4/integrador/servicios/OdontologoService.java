package com.grupo4.integrador.servicios;

import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Odontologo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IDao<Odontologo> daoOdontologo;

    public OdontologoService(IDao<Odontologo> daoOdontologo) {
        this.daoOdontologo = daoOdontologo;
    }

    public Odontologo registrar(Odontologo o) {
        return daoOdontologo.registrar(o);
    }

    public List<Odontologo> listar() {
        return daoOdontologo.listar();
    }

    public Odontologo buscar(int id) {
        return daoOdontologo.buscar(id);
    }

    public void eliminar(int id) {
        daoOdontologo.eliminar(id);
    }

}
