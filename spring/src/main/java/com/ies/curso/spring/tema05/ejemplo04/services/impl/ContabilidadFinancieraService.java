package com.ies.curso.spring.tema05.ejemplo04.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.persistence.ContabilidadDao;
import com.ies.curso.spring.tema05.ejemplo04.services.ContabilidadService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service("contabilidadFinanciera")
@Slf4j
public class ContabilidadFinancieraService implements ContabilidadService {

	@Getter
	@Autowired
	protected ContabilidadDao contabilidadDao;

	@Override
	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		log.info("Extrayendo registros de base de datos");
		return contabilidadDao.obtenerRegistrosPeriodo(fechaInicio, fechaFin);
	}

}
