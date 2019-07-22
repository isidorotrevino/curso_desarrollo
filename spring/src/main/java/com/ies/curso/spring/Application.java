package com.ies.curso.spring;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ies.curso.spring.tema05.ejemplo03.Saludador;
import com.ies.curso.spring.tema05.ejemplo04.config.ContabilidadConfig;
import com.ies.curso.spring.tema05.ejemplo04.services.CalculadoraContabilidad;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		//// EJEMPLO 3
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		Saludador saludador = ctx.getBean(Saludador.class);
		saludador.saludar();
		
		//// EJEMPLO 4
		ContabilidadConfig config = ctx.getBean("contabilidadConfig",ContabilidadConfig.class);
		log.info("URL {}",config.getUrl());
		log.info("Usuario {}",config.getUsuario());
		CalculadoraContabilidad calc = ctx.getBean(CalculadoraContabilidad.class);
		calc.obtenerSaldoPeriodo(LocalDate.now(), LocalDate.parse("2019-01-01"));
		
		/// VARIOS
		log.info("Mostramos los beans cargados");
		for(String str : ctx.getBeanDefinitionNames()) {
			log.info("-> {}",str);
		}
	}

}
