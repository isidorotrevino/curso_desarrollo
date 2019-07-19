package com.ies.curso.spring.tema05.ejemplo04.service;

import java.time.LocalDate;
import java.util.List;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;

public interface ContabilidadService {

	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio, LocalDate fechaFin);
}
