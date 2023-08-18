package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.daos.IDao;

import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";
    private final static Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);


    private static Connection connection;

    private static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            LOGGER.info("Conexion exitosa a la db.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //Usar si la tabla no existe
    public static void crearTablaOdontologo() {
        try {
            Statement stm = getConnection().createStatement();
            stm.execute(Query.CREATE_TABLE);
            LOGGER.info("Tabla creada con exito!");
            stm.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean registrar(Odontologo odontologo) {
        boolean success = false;
        try (PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE)) {
            pst.setInt(1, odontologo.getId());
            pst.setString(2, odontologo.getNMatricula());
            pst.setString(3, odontologo.getNombre());
            pst.setString(4, odontologo.getApellido());
            pst.execute();
            LOGGER.info("se registro un odontologo!");

            pst.close();
            connection.close();
            success = true;

        } catch (Exception e) {
            LOGGER.error("Error al registrar el usuario!");
        }
        return success;
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
