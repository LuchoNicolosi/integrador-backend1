package com.grupo4.integrador.utilidades;

public class Query {
    public final static String INSERT_VALUE_ODONTOLOGO = "INSERT INTO ODONTOLOGO(nombre,apellido,matricula) VALUES(?,?,?)";
    public final static String INSERT_VALUE_PACIENTE = "INSERT INTO PACIENTE(nombre,apellido,domicilio,dni,fecha_alta) VALUES(?,?,?,?,?)";
    public final static String INSERT_VALUE_TURNO = "INSERT INTO TURNO(paciente_id,odontologo_id,fecha_hora) VALUES(?,?,?);";
}
