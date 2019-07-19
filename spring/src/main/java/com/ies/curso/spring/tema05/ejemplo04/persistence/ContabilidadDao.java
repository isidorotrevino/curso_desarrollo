package com.ies.curso.spring.tema05.ejemplo04.persistence;

import java.time.LocalDate;
import java.util.List;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;

public interface ContabilidadDao {

	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio, LocalDate fechaFin);
	
}
