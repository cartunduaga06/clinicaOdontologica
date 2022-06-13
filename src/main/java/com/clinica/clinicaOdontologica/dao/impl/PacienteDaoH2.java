package com.clinica.clinicaOdontologica.dao.impl;

import com.clinica.clinicaOdontologica.dao.Idao;
import com.clinica.clinicaOdontologica.dao.impl.DomicilioDaoH2;
import com.clinica.clinicaOdontologica.model.Domicilio;
import com.clinica.clinicaOdontologica.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements Idao {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/db_clinica15;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";

    private DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();


    @Override
    public Object guardar(Object o) {
        return null;
    }

    @Override
    public Object buscar(int id) {
        return null;
    }

    @Override
    public List buscarTodos() {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Object actualizar(int id) {
        return null;
    }
}
