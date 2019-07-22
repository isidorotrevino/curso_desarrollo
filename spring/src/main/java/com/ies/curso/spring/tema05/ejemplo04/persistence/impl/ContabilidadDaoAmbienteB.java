package com.ies.curso.spring.tema05.ejemplo04.persistence.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.persistence.ContabilidadDao;

public class ContabilidadDaoAmbienteB implements ContabilidadDao {

	@Override
	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		return new ArrayList<RegistroContable>();
	}

}
