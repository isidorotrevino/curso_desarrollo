package com.ies.curso.spring.tema05.ejemplo04.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.service.CalculadoraContabilidad;
import com.ies.curso.spring.tema05.ejemplo04.service.ContabilidadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CalculadoraContabilidadImpl implements CalculadoraContabilidad {

	@Autowired
	@Qualifier("contabilidadFinanciera")
	protected ContabilidadService contabilidadService;
	
	@Override
	public Double obtenerSaldoPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		log.info("Calculando datos usando {}",contabilidadService.getClass());
		Double acumulador = 0.0d;
		List<RegistroContable> registros = contabilidadService
				.obtenerRegistrosPeriodo(fechaInicio, fechaFin);
		
		for(RegistroContable c : registros) {
			acumulador += c.getAbono();
			acumulador -= c.getCargo();
		}
		log.info("Regresando saldo {}",acumulador);
		return acumulador;
	}

}
