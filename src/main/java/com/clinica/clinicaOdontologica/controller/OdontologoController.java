package com.clinica.clinicaOdontologica.controller;


import com.clinica.clinicaOdontologica.dao.impl.OdontologoDaoH2;
import com.clinica.clinicaOdontologica.model.Odontologo;
import com.clinica.clinicaOdontologica.service.OdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());


    @GetMapping("odontologo")
    public String getOdontologo(Model model){
        model.addAttribute("nombre",odontologoService.buscarID(1).getNombre());



        return "odontologo";


    }


}
