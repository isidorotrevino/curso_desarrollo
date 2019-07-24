package com.ies.curso.spring.tema08.ejemplo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ies.curso.spring.tema08.ejemplo01.service.CountryInfoService;

@RestController
public class SoapCallingController {

	@Autowired
	protected CountryInfoService countryService;
	
	@GetMapping(path="/invocarSoap",produces="text/plain")
	public String invocarServicio(@RequestParam(name = "codigo", required = true) 
		String codigo) {
		return countryService.obtenerCapital(codigo);
	}

}
