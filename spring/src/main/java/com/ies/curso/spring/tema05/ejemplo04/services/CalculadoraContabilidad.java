package com.ies.curso.spring.tema05.ejemplo04.services;

import java.time.LocalDate;

public interface CalculadoraContabilidad {
	
	public Double obtenerSaldoPeriodo(LocalDate fechaInicio,
			LocalDate fechaFin);
}
