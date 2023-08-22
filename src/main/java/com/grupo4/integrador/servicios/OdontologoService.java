package com.grupo4.integrador.servicios;

import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IDao<Odontologo> daoOdontologo;

    public IDao<Odontologo> getDaoOdontologo() {
        return daoOdontologo;
    }

    @Autowired
    public OdontologoService(IDao<Odontologo> daoOdontologo) {
        this.daoOdontologo = daoOdontologo;
    }

    public Odontologo registrar(Odontologo o) {
        return daoOdontologo.registrar(o);
    }

    public List<Odontologo> listar() {
        return daoOdontologo.listar();
    }

}
