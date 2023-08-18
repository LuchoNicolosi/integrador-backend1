package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.daos.IDao;
import com.grupo4.integrador.entidades.Paciente;
import org.apache.log4j.Logger;

import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";
    private final static Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);


    @Override
    public boolean registrar(Paciente paciente) {
        return false;
    }

    @Override
    public List<Paciente> listar() {
        return null;
    }
}
