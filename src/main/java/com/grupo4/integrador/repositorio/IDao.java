package com.grupo4.integrador.repositorio;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IDao<T> {
    T registrar(T t);

    List<T> listar();

    T buscar(int id);

    void eliminar(int id);
}
