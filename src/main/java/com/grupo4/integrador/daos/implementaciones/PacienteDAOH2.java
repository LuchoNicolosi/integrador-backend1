package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.daos.IDao;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";
    private final static Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);

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
    public static void crearTablaPaciente() {
        try {
            Statement stm = getConnection().createStatement();
            stm.execute(Query.CREATE_TABLE_PACIENTE);
            LOGGER.info("Tabla creada con exito!");
            stm.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean registrar(Paciente paciente) {
        boolean flag =  false;
        try(PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE_PACIENTE)){
            pst.setInt(1, paciente.getId());
            pst.setString(2, paciente.getNombre());
            pst.setString(3,paciente.getApellido());
            pst.setString(4,paciente.getDomicilio());
            pst.setString(5,paciente.getDni());
            pst.setString(6,paciente.getFechaAlta());
            pst.execute();
            LOGGER.info("SE REGISTRO UN PACIENTE!");
            pst.close();
            getConnection().close();
            flag = true;


        }catch(Exception e){
            LOGGER.error("algo salio mal", e);
        }
        return flag;
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> pacientes = new ArrayList<>();
        try (PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM PACIENTE")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pacientes.add(new Paciente(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DOMICILIO"), rs.getString("DNI"),rs.getString("FECHA_ALTA")));
            }
            LOGGER.info(pacientes);
        } catch (Exception e) {
            LOGGER.error("error al listar los odontologos");
            return new ArrayList<>();
        }
        return pacientes;
    }
}
