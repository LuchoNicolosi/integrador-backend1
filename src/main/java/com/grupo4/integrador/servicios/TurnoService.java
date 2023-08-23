package com.grupo4.integrador.servicios;

import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    IDao<Turno> daoTurno;

    public TurnoService(IDao<Turno> daoTurno) {
        this.daoTurno = daoTurno;
    }

    public Turno registrar(Turno turno) {
        return daoTurno.registrar(turno);
    }

    public List<Turno> listar() {
        return daoTurno.listar();
    }
}
