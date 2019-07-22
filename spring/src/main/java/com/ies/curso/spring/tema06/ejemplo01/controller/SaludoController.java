package com.ies.curso.spring.tema06.ejemplo01.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public String saludar(@RequestParam(name="nombre",required = true)String nombre,
			Model model) {
		model.addAttribute("nombre",nombre);
		model.addAttribute("informacion",new Informacion());
		return "saludo";
	}
	
	
	@PostMapping("/saludar/enviarDatos")
	public String enviarDatos(@ModelAttribute @Valid Informacion datos, BindingResult bindingResult) {
		log.info("Procesamos envio de datos {}",datos);
		log.info("Que instancia de binding result {}",bindingResult.getClass());
		BeanPropertyBindingResult result = (BeanPropertyBindingResult) bindingResult;
		for(FieldError e : result.getFieldErrors()) {
			log.info("--> {}={} ({})",e.getField(),e.getRejectedValue(),e.getCode());
		}
		if (bindingResult.hasErrors()) {
            return "saludo";
        }
		return "/resultado";
	}
	
}
