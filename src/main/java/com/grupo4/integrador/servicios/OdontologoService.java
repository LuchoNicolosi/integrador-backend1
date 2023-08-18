package com.grupo4.integrador.servicios;

import com.grupo4.integrador.daos.implementaciones.OdontologoDAOH2;
import com.grupo4.integrador.daos.IDao;
import com.grupo4.integrador.entidades.Odontologo;

import java.util.List;

public class OdontologoService {
    IDao<Odontologo> daoOdontologo;

    public IDao<Odontologo> getDaoOdontologo() {
        return daoOdontologo;
    }

    public OdontologoService(IDao daoOdontologo) {
        this.daoOdontologo = daoOdontologo;
    }

    public boolean registrar(Odontologo o) {
        return daoOdontologo.registrar(o);
    }

    public List<Odontologo> listar() {
        return daoOdontologo.listar();
    }

}
