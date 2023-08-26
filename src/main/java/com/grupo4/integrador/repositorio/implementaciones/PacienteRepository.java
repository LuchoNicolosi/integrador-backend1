package com.grupo4.integrador.repositorio.implementaciones;


import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static com.grupo4.integrador.repositorio.implementaciones.db.getConnection;

@Repository
public class PacienteRepository implements IRepository<Paciente> {
    private final static Logger LOGGER = Logger.getLogger(PacienteRepository.class);
    private Integer autoIncrementId = 0;

    @Override
    public Paciente registrar(Paciente paciente) {
        Paciente pac = null;
        try (PreparedStatement pst = db.getConnection().prepareStatement(Query.INSERT_VALUE_PACIENTE)) {
            pst.setString(1, paciente.getNombre());
            pst.setString(2, paciente.getApellido());
            pst.setString(3, paciente.getDni());
            pst.setString(4, paciente.getFechaAlta());
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
        try (PreparedStatement pst = db.getConnection().prepareStatement(Query.LISTAR_PACIENTES)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pacientes.add(new Paciente(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DNI"), rs.getString("FECHA_ALTA")));
            }
            LOGGER.info(pacientes);
        } catch (Exception e) {
            LOGGER.error("error al listar los pacientes");
            return new ArrayList<>();
        }
        return pacientes;
    }

    @Override
    public Paciente buscar(int id) {
        Paciente paciente = null;
        try (PreparedStatement pst = getConnection().prepareStatement(Query.BUSCAR_PACIENTE)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DNI"), rs.getString("FECHA_ALTA"));
            }
            LOGGER.info("PacienteId: " + paciente.getId());
        } catch (Exception e) {
            LOGGER.error("Paciente no encontrado." + e);
        }
        return paciente;
    }


    @Override
    public void eliminar(int id) {
        if (buscar(id) != null) {
            try (PreparedStatement pst = getConnection().prepareStatement(Query.DELETE_PACIENTE)) {
                pst.setInt(1, id);
                pst.execute();
                LOGGER.info("Paciente eliminado - ID >" + id);
            } catch (Exception e) {
                LOGGER.error("Error eliminando el Paciente.");
            }
        }
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return null;
    }
}
