package com.clinica.clinicaOdontologica.service;

import com.clinica.clinicaOdontologica.dao.Idao;
import com.clinica.clinicaOdontologica.model.Odontologo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OdontologoService {

    private Idao<Odontologo> odontologoIdao;
    private List<Odontologo> listaOdontologos =  new ArrayList<>();

    public OdontologoService() {
        listaOdontologos = Arrays.asList(new Odontologo(1,"narvaez","andrea","1234"),
                new Odontologo(2,"jaja","amcasc", "234"));

    }


    public List<Odontologo> getListaOdontologos() {



        return listaOdontologos;
    }

    public Odontologo buscarID(int id){
        Odontologo odontologo = null;
        for(Odontologo odotologoaux: listaOdontologos){
            if(odotologoaux.getId() == id){
                odotologoaux.getId();
                odontologo =  odotologoaux;
            }

        }
        return odontologo;
    }

    //constructor IDAO
    public OdontologoService(Idao<Odontologo> odontologoIdao) {
        this.odontologoIdao = odontologoIdao;
    }

    //operaciones
    public Odontologo guardar (Odontologo odontologo) {
        return odontologoIdao.guardar(odontologo);
    }



    public List<Odontologo> buscarTodos() {
        return odontologoIdao.buscarTodos();
    }

}
