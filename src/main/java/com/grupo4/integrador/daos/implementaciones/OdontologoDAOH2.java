package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.daos.IDao;

import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.grupo4.integrador.daos.implementaciones.db.getConnection;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private final static Logger LOGGER = Logger.getLogger(db.class);

    //Usar si la tabla no existe
    public static void crearTablaOdontologo() {
        try (Statement stm = getConnection().createStatement();) {
            stm.execute(Query.CREATE_TABLE);
            LOGGER.info("Tabla Odontologo creada con exito!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Odontologo odon = null;
        try (PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE_ODONTOLOGO)) {
            pst.setInt(1, odontologo.getId());
            pst.setString(2, odontologo.getNMatricula());
            pst.setString(3, odontologo.getNombre());
            pst.setString(4, odontologo.getApellido());
            pst.execute();
            LOGGER.info("se registro un odontologo!");
            odon = odontologo;

        } catch (Exception e) {
            LOGGER.error("Error al registrar el usuario!");
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
