package com.clinica.clinicaOdontologica.service;

import com.clinica.clinicaOdontologica.model.Domicilio;
import com.clinica.clinicaOdontologica.model.Paciente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteService {

    List<Paciente> listaPacientes =  new ArrayList<>();

    public PacienteService() {
        Domicilio domicilio =  new Domicilio(1,"14","calle 20", "florencia","caqueta");
        listaPacientes = Arrays.asList(new Paciente(1L, "carlos","ariztizabal","carlos@gmail.com", domicilio),
                new Paciente( 2L, "ascasc","ariztascasizabal","carlo2@gmail.com", domicilio));
    }

    public List<Paciente> getListaPacientes() {


        return listaPacientes;
    }

    public Paciente buscarEmail(String email){
        Paciente pacienteretorno = null;

        for(Paciente pacienteAux: listaPacientes){
            if(pacienteAux.getEmail().equals(email)){
                pacienteretorno = pacienteAux;
            }
        }

        return pacienteretorno;
    }
}
