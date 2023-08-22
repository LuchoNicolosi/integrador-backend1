package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.repositorio.IDao;

import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
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
            pst.setString(1, odontologo.getNMatricula());
            pst.setString(2, odontologo.getNombre());
            pst.setString(3, odontologo.getApellido());
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
        try (PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM ODONTOLOGO")) {
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
}
