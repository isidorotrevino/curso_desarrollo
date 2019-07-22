package com.ies.curso.spring.tema06.ejemplo02.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.services.ContabilidadService;
import com.ies.curso.spring.tema06.ejemplo02.dto.Resultado;

@RestController
@RequestMapping("/restapi")
public class ContabilidadController {

	@Autowired
	@Qualifier("contabilidadFinanciera")
	protected ContabilidadService contabilidadService;
	
	@GetMapping(path = "/",produces = "application/json")
	public List<RegistroContable> desplegarRegistros(){
		return contabilidadService.obtenerRegistrosPeriodo(LocalDate.now(), LocalDate.now());
	}
	
	@PostMapping(path = "/",produces = "text/xml")
	public Resultado crearRegistroContable(@RequestBody RegistroContable registro) {
		return new Resultado(1l,true,"Registro creado");
	}
	
	@DeleteMapping(path = "/",produces = "application/json")
	public Resultado eliminarRegistroContable(@RequestBody RegistroContable registro) {
		return new Resultado(5l,true,"Registro eliminado");
	}
}
