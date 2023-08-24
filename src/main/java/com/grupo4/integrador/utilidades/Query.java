package com.grupo4.integrador.utilidades;

public class Query {

    //ODONTOLOGOS
    public final static String INSERT_VALUE_ODONTOLOGO = "INSERT INTO ODONTOLOGO(nombre,apellido,matricula) VALUES(?,?,?)";
    public final static String BUSCAR_ODONTOLOGO = "SELECT * FROM ODONTOLOGO WHERE id=?;";
    public final static String LISTAR_ODONTOLOGOS = "SELECT * FROM ODONTOLOGO;";
    public final static String ACTUALIZAR_ODONTOLOGO = "UPDATE ODONTOLOGO SET matricula=?  WHERE id=?;";
    public final static String DELETE_ODONTOLOGO = "DELETE FROM ODONTOLOGO WHERE id=?;";

    //PACIENTES
    public final static String INSERT_VALUE_PACIENTE = "INSERT INTO PACIENTE(nombre,apellido,domicilio,dni,fecha_alta) VALUES(?,?,?,?,?)";
    public final static String LISTAR_PACIENTES = "SELECT * FROM PACIENTE;";
    public final static String BUSCAR_PACIENTE = "SELECT * FROM PACIENTE WHERE id=?;";
    public final static String ACTUALIZAR_PACIENTE = "UPDATE PACIENTE SET matricula=?  WHERE id=?;";
    public final static String DELETE_PACIENTE = "DELETE FROM PACIENTE WHERE id=?;";

    //TURNOS
    public final static String LISTAR_TURNOS = "SELECT * FROM TURNO;";
    public final static String INSERT_VALUE_TURNO = "INSERT INTO TURNO(paciente_id,odontologo_id,fecha_hora) VALUES(?,?,?);";
    public final static String BUSCAR_TURNO = "SELECT * FROM TURNO WHERE ID=?;";
    public final static String ACTUALIZAR_TURNO = "UPDATE TURNO SET odontologo_id=? fecha_hora=?  WHERE id=?;";
    public final static String DELETE_TURNO = "DELETE FROM TURNO WHERE id=?;";
}
