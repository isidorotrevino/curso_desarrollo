package com.ies.curso.tema04.ejemplo01;

import java.time.LocalDate;
import java.util.List;

public class CalculadoraContabilidad {

	protected ContabilidadService contabilidadService;
	
	public void setContabilidadService(ContabilidadService contabilidadService) {
		this.contabilidadService = contabilidadService;
	}

	public Double obtenerSaldoPeriodo(LocalDate fechaInicio,
			LocalDate fechaFin) {
		Double acumulador = 0.0d;
		List<RegistroContable> registros = contabilidadService
				.obtenerRegistrosPeriodo(fechaInicio, fechaFin);
		
		for(RegistroContable c : registros) {
			acumulador += c.getAbono();
			acumulador -= c.getCargo();
		}
		return acumulador;
	}
	
}
