package com.grupo4.integrador.utilidades;

public class Query {
    public final static String CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO;"+
            "CREATE TABLE ODONTOLOGO(ID INT PRIMARY KEY , MATRICULA VARCHAR(255), NOMBRE VARCHAR(255), APELLIDO VARCHAR(255) );";
    public final static String INSERT_VALUE_ODONTOLOGO = "INSERT INTO ODONTOLOGO VALUES(?,?,?,?)";

    public final static String CREATE_TABLE_PACIENTE = "DROP TABLE IF EXISTS PACIENTE;" +
            "CREATE TABLE PACIENTE(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), DOMICILIO VARCHAR(255), DNI VARCHAR(255), FECHA_ALTA VARCHAR(255));";
    public final static String INSERT_VALUE_PACIENTE = "INSERT INTO PACIENTE VALUES(?,?,?,?,?,?)";

    public final static String CREATE_TABLE_TURNO = "DROP TABLE IF EXISTS TURNO;"+
            "CREATE TABLE TURNO(turnoID int NOT NULL, pacienteID int ,odontologoID int, fecha_hora VARCHAR(255), PRIMARY KEY(turnoID),  FOREIGN KEY (pacienteID) REFERENCES PACIENTE(id), FOREIGN KEY (odontologoID) REFERENCES ODONTOLOGO(id));";
    public final static String INSERT_VALUE_TURNO = "INSERT INTO TURNO VALUES(?,?,?,?);";
}
