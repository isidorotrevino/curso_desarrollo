package com.ies.curso.spring.tema05.ejemplo04.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.service.ContabilidadService;

@Service("contabilidadFiscal")
public class ContabilidadFiscalService implements ContabilidadService {

	@Override
	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		throw new IllegalArgumentException("Todavía no lo implementamos");
	}

}
