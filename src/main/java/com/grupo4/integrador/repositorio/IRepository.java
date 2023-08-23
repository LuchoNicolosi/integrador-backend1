package com.grupo4.integrador.repositorio;

import java.util.List;

public interface IRepository<T> {
    T registrar(T t);

    List<T> listar();

    T buscar(int id);

    void eliminar(int id);
}
