package com.ies.curso.spring.tema05.ejemplo04.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ies.curso.spring.tema05.ejemplo04.persistence.ContabilidadDao;
import com.ies.curso.spring.tema05.ejemplo04.persistence.impl.ContabilidadDaoAmbienteB;
import com.ies.curso.spring.tema05.ejemplo04.persistence.impl.ContabilidadDaoPruebas;

import lombok.Getter;

@Configuration
public class ContabilidadConfig {

	@Value("${contabilidad.url}")
	@Getter
	protected String url;
	@Value("${contabilidad.usuario}")
	@Getter
	protected String usuario;
	
	@Bean
	@ConditionalOnProperty(value="ambiente",havingValue = "a")
	public ContabilidadDao contabilidadDao() {
		ContabilidadDao dao = new ContabilidadDaoPruebas();
		return dao;
	}
	
	@Bean
	@ConditionalOnProperty(value="ambiente",havingValue = "b")
	public ContabilidadDao contabilidadDaoB() {
		ContabilidadDao dao = new ContabilidadDaoAmbienteB();
		return dao;
	}
}
