package com.grupo4.integrador.repositorio.implementaciones;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    //Refactorizacion de codigo!!!!
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";
    private final static Logger LOGGER = Logger.getLogger(db.class);
    private static Connection connection;

    protected static Connection getConnection() {

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

    public static void RunTables() {
        OdontologoDAOH2.crearTablaOdontologo();
        PacienteDAOH2.crearTablaPaciente();
        TurnoDAOH2.crearTablaTurno();
    }
}
