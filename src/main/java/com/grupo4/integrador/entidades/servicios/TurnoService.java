package com.grupo4.integrador.entidades.servicios;

import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    IRepository<Turno> daoTurno;

    public TurnoService(IRepository<Turno> daoTurno) {
        this.daoTurno = daoTurno;
    }

    public Turno registrar(Turno turno) {
        return daoTurno.registrar(turno);
    }

    public List<Turno> listar() {
        return daoTurno.listar();
    }
}
