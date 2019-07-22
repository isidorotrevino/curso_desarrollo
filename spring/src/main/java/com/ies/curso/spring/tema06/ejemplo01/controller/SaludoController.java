package com.ies.curso.spring.tema06.ejemplo01.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ies.curso.spring.tema06.ejemplo01.dto.Informacion;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SaludoController {

	@GetMapping("/saludar")
	public String saludar(@RequestParam(name="nombre",required = false)String nombre,
			Model model) {
		model.addAttribute("nombre",nombre);
		model.addAttribute("informacion",new Informacion());
		return "saludo";
	}
	
	
	@PostMapping("/saludar/enviarDatos")
	public String enviarDatos(@ModelAttribute @Valid Informacion datos, BindingResult bindingResult) {
		log.info("Procesamos envio de datos {}",datos);
		if (bindingResult.hasErrors()) {
            return "saludo";
        }
		return "/resultado";
	}
	
}
