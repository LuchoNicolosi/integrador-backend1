package com.grupo4.integrador.servicios;

import com.grupo4.integrador.daos.IDao;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Turno;

import java.util.List;

public class TurnoService {
    IDao<Turno> daoTurno;

    public IDao<Turno> daoTurno() {
        return daoTurno;
    }

    public TurnoService(IDao daoTurno) {
        this.daoTurno = daoTurno;
    }

    public boolean registrar(Turno turno) {
        return daoTurno.registrar(turno);
    }

    public List<Turno> listar() {
        return daoTurno.listar();
    }
}
