package com.clinica.clinicaOdontologica.service;

import com.clinica.clinicaOdontologica.dao.impl.PacienteDaoH2;
import com.clinica.clinicaOdontologica.model.Domicilio;
import com.clinica.clinicaOdontologica.model.Paciente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteService {

    List<Paciente> listaPacientes =  new ArrayList<>();

    public PacienteService(PacienteDaoH2 pacienteDaoH2) {
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
    public Paciente registrar(Paciente paciente){
        listaPacientes.add(paciente);
        return paciente;
    }

    public Paciente actualizar(Paciente paciente) {
        for (Paciente pacienteAux : listaPacientes) {
            if (pacienteAux.getId() == paciente.getId()) {
                pacienteAux.setNombre(paciente.getNombre());
                pacienteAux.setApellido(paciente.getApellido());
                pacienteAux.setEmail(paciente.getEmail());
                pacienteAux.setDomicilio(paciente.getDomicilio());
            }
        }
        return paciente;

    }


}
