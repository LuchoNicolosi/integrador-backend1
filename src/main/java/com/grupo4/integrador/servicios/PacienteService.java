package com.grupo4.integrador.servicios;

import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Paciente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    IDao<Paciente> daoPaciente;

    public IDao<Paciente> getDaoOdontologo() {
        return daoPaciente;
    }


    public PacienteService(@Qualifier("pacienteDAOH2") IDao daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public Paciente registrar(Paciente p) {
        return daoPaciente.registrar(p);
    }

    public List<Paciente> listar() {
        return daoPaciente.listar();
    }

}
