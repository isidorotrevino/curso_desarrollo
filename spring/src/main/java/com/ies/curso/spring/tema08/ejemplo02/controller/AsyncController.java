package com.ies.curso.spring.tema08.ejemplo02.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.curso.spring.tema08.ejemplo02.service.AsyncService;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/async")
@Slf4j
public class AsyncController {

	@Autowired
	protected AsyncService asyncService;
	
	@GetMapping(path = "/", produces = "application/json")
	public Map<String, Object> invocarAsync() {
		Map<String, Object> resultado = Collections.singletonMap("exito", "true");
		asyncService.metodoAsincrono(false);
		return resultado;
	}

	@GetMapping(path = "/ex", produces = "application/json")
	public Map<String, Object> invocarAsyncException() {
		log.info("Thread del controller {}",Thread.currentThread().getName());
		Map<String, Object> resultado = Collections.singletonMap("exito", "true");
		asyncService.metodoAsincrono(true);
		return resultado;
	}

}
