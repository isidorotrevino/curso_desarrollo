package com.ies.curso.tema04.ejemplo01;

import java.time.LocalDate;
import java.util.List;

public interface ContabilidadService {

	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio,
			LocalDate fechaFin);
	
}
