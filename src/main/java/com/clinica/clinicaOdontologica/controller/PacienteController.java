package com.clinica.clinicaOdontologica.controller;

import com.clinica.clinicaOdontologica.model.Paciente;
import com.clinica.clinicaOdontologica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PacienteController {

    private PacienteService pacienteService = new PacienteService();

    @GetMapping("paciente")
    public String getPaciente (Model model){
        Paciente paciente = pacienteService.buscarEmail("carlos@gmail.com");
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "index";


    }



}
