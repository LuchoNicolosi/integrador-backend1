package com.grupo4.integrador.utilidades;

public class Query {
    public final static String CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO;"+
            "CREATE TABLE ODONTOLOGO(id SERIAL PRIMARY KEY, matricula VARCHAR(255), nombre VARCHAR(255), apellido VARCHAR(255));";
    public final static String INSERT_VALUE_ODONTOLOGO = "INSERT INTO ODONTOLOGO(nombre,apellido,matricula) VALUES(?,?,?)";

    public final static String CREATE_TABLE_PACIENTE = "DROP TABLE IF EXISTS PACIENTE;" +
            "CREATE TABLE PACIENTE(id SERIAL PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), domicilio VARCHAR(255), dni VARCHAR(255), fecha_alta VARCHAR(255));";
    public final static String INSERT_VALUE_PACIENTE = "INSERT INTO PACIENTE(nombre,apellido,domicilio,dni,fecha_alta) VALUES(?,?,?,?,?)";

    public final static String CREATE_TABLE_TURNO = "DROP TABLE IF EXISTS TURNO;"+
            "CREATE TABLE TURNO(id SERIAL PRIMARY KEY, paciente_id int ,odontologo_id int, fecha_hora VARCHAR(255), FOREIGN KEY (paciente_id) REFERENCES PACIENTE(id), FOREIGN KEY (odontologo_id) REFERENCES ODONTOLOGO(id));";
    public final static String INSERT_VALUE_TURNO = "INSERT INTO TURNO(paciente_id,odontologo_id,fecha_hora) VALUES(?,?,?);";
}
