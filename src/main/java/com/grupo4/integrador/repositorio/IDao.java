package com.grupo4.integrador.repositorio;

import java.util.List;

public interface IDao<T> {
    T registrar(T t);

    List<T> listar();

}
