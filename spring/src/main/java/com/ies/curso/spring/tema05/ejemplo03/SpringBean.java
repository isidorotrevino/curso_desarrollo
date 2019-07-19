package com.ies.curso.spring.tema05.ejemplo03;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SpringBean implements Saludador{

	@Override
	public void saludar() {
		log.info("HOLA MUNDO");
	}

	
	
}
