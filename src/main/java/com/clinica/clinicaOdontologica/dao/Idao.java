package com.clinica.clinicaOdontologica.dao;

import java.util.List;

public interface Idao<T> {

    public T guardar(T t);
    public T buscar(int id);
    public List<T> buscarTodos();
    void eliminar(int id);
    T actualizar(int id);

}
