package com.clinica.clinicaOdontologica.controller;

import com.clinica.clinicaOdontologica.dao.impl.PacienteDaoH2;
import com.clinica.clinicaOdontologica.model.Paciente;
import com.clinica.clinicaOdontologica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping("paciente")

    public Paciente registrar(Paciente paciente){
        return pacienteService.registrar(paciente);
    };

    public Paciente actualizar(Paciente paciente){
        return pacienteService.actualizar(paciente);
    };
    @GetMapping("pacientebuscar")
    public Paciente buscarEmail(String email){
        return pacienteService.buscarEmail(email);
    };





}
