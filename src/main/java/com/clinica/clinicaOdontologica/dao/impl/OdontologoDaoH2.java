package com.clinica.clinicaOdontologica.dao.impl;

import com.clinica.clinicaOdontologica.dao.Idao;
import com.clinica.clinicaOdontologica.dao.configuracion.ConfiguracionJDBC;

import com.clinica.clinicaOdontologica.model.Odontologo;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDaoH2 implements Idao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_odontologos2";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";
    private static final String SQL_CREATE = "create table IF NOT EXISTS odontologos (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, matricula varchar(255), nombre varchar(255),apellido varchar (255));";
    private static final String SQL_CONSULTA = "select * from odontologos";
    private ConfiguracionJDBC configuracionJDBC;

    public OdontologoDaoH2(ConfiguracionJDBC configuracionJDBC) {
        this.configuracionJDBC = configuracionJDBC;
    }

    public OdontologoDaoH2(){

    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;






        try {
            logger.info("levantando el driver  y conexiones para guardar");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            logger.info("creando sentencia");
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos(matricula, nombre, apellido) VALUES(?,?,?)");
            //preparedStatement.setInt(1,odontologo.getId());
            preparedStatement.setString(1,odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());


            logger.info("ejecutando la sentencia SQL");
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

        logger.info("añadiendo a "+odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }


    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            logger.info("levantando el driver  y conexiones para consultar");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            logger.info("creando sentencia de consulta");
            preparedStatement = connection.prepareStatement(SQL_CONSULTA);

            logger.info("ejecutando sentencia de consulta");
            ResultSet result = preparedStatement.executeQuery();

            logger.info("obteniendo resultados");
            while (result.next()){
                int id = result.getInt("id");
                String matricula = result.getString("matricula");
                String nombre = result.getString("nombre");
                String apellidos = result.getString("apellido");
                odontologos.add(new Odontologo(id, matricula, nombre, apellidos));
            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

        logger.info(odontologos);
        return odontologos;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Odontologo actualizar(int id) {
        return null;
    }
}
