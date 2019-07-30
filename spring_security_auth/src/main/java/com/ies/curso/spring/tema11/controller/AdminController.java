package com.ies.curso.spring.tema11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ies.curso.spring.tema11.service.SeguridadService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	protected SeguridadService seguridadService;
	
	@GetMapping("/")
	public String index(ModelMap modelo) {
		modelo.put("admin", "");
		return "admin";
	}
	
	@GetMapping("/operacion")
	public String user(ModelMap	 modelo) {
		modelo.put("admin", seguridadService.operacionAdministrador());
		return "admin";
	}
	
}
