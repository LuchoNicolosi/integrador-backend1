package com.grupo4.integrador.daos;

import java.util.List;

public interface IDao<T> {
    boolean registrar(T t);

    List<T> listar();

}
