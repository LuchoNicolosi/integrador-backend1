package com.grupo4.integrador.utilidades;

public class Query {
    public final static String CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO;"+
            "CREATE TABLE ODONTOLOGO(ID INT PRIMARY KEY , MATRICULA VARCHAR(255), NOMBRE VARCHAR(255), APELLIDO VARCHAR(255) );";
    public final static String INSERT_VALUE = "INSERT INTO ODONTOLOGO VALUES(?,?,?,?)";

}
