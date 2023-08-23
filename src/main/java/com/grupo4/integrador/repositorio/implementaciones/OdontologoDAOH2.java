package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.repositorio.IDao;

import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.grupo4.integrador.repositorio.implementaciones.db.getConnection;

@Repository
public class OdontologoDAOH2 implements IDao<Odontologo> {
    private final static Logger LOGGER = Logger.getLogger(db.class);
    private Integer autoIncrementId = 0;

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Odontologo odon = null;

        try (PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE_ODONTOLOGO)) {
            pst.setString(1, odontologo.getNombre());
            pst.setString(2, odontologo.getApellido());
            pst.setString(3, odontologo.getNMatricula());
            pst.execute();
            LOGGER.info("se registro un odontologo!");

            odon = odontologo;
            odon.setId(autoIncrementId += 1);

        } catch (Exception e) {
            LOGGER.error("Error al registrar el odontologo!");
        }
        return odon;
    }

    @Override
    public List<Odontologo> listar() {
        List<Odontologo> odontologos = new ArrayList<>();
        try (PreparedStatement pst = getConnection().prepareStatement(Query.LISTAR_ODONTOLOGOS)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                odontologos.add(new Odontologo(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("MATRICULA")));
            }
            LOGGER.info(odontologos);
        } catch (Exception e) {
            LOGGER.error("error al listar los odontologos");
            return new ArrayList<>();
        }
        return odontologos;
    }

    @Override
    public Odontologo buscar(int id) {
        Odontologo odontologo = null;
        try (PreparedStatement pst = getConnection().prepareStatement(Query.BUSCAR_ODONTOLOGO)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                odontologo = new Odontologo(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("MATRICULA"));
            }
            LOGGER.info("OdontologoId: " + odontologo.getId());
        } catch (Exception e) {
            LOGGER.error("Odontologo no encontrado. " + e);
        }
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        if (buscar(id) != null) {
            try (PreparedStatement pst = getConnection().prepareStatement(Query.DELETE_ODONTOLOGO)) {
                pst.setInt(1, id);
                pst.execute();
                LOGGER.info("Odontologo eliminado - ID >" + id);
            } catch (Exception e) {
                LOGGER.error("Error eliminando el Odontologo.");
            }
        }
    }


}
