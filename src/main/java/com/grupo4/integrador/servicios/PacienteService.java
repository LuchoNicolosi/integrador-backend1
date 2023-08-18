package com.grupo4.integrador.servicios;

import com.grupo4.integrador.daos.IDao;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;

import java.util.List;

public class PacienteService {
    IDao<Paciente> daoPaciente;

    public IDao<Paciente> getDaoOdontologo() {
        return daoPaciente;
    }

    public PacienteService(IDao daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public boolean registrar(Paciente p) {
        return daoPaciente.registrar(p);
    }

    public List<Paciente> listar() {
        return daoPaciente.listar();
    }

}
