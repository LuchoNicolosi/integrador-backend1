package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteDAOH2 implements IDao<Paciente> {
    private final static Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);
    private Integer autoIncrementId = 0;
    @Override
    public Paciente registrar(Paciente paciente) {
        Paciente pac = null;
        try (PreparedStatement pst = db.getConnection().prepareStatement(Query.INSERT_VALUE_PACIENTE)) {
            pst.setString(1, paciente.getNombre());
            pst.setString(2, paciente.getApellido());
            pst.setString(3, paciente.getDomicilio());
            pst.setString(4, paciente.getDni());
            pst.setString(5, paciente.getFechaAlta());
            pst.execute();
            LOGGER.info("SE REGISTRO UN PACIENTE!");
            pac = paciente;
            pac.setId(autoIncrementId += 1);
        } catch (Exception e) {
            LOGGER.error("algo salio mal", e);
        }
        return pac;
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> pacientes = new ArrayList<>();
        try (PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM PACIENTE")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pacientes.add(new Paciente(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DOMICILIO"), rs.getString("DNI"), rs.getString("FECHA_ALTA")));
            }
            LOGGER.info(pacientes);
        } catch (Exception e) {
            LOGGER.error("error al listar los odontologos");
            return new ArrayList<>();
        }
        return pacientes;
    }
}
