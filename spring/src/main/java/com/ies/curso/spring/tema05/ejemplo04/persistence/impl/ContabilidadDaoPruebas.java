package com.ies.curso.spring.tema05.ejemplo04.persistence.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.persistence.ContabilidadDao;

public class ContabilidadDaoPruebas implements ContabilidadDao {

	@Override
	public List<RegistroContable> obtenerRegistrosPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		List<RegistroContable> registros = new ArrayList<>();
		Random rand = new Random();
		double rangeMin = 5000;
		double rangeMax = 10000;
		for(int i=1;i<=500;i++) {
			RegistroContable r = new RegistroContable();
			r.setAbono(rangeMin + (rangeMax - rangeMin) * rand.nextDouble());
			r.setCargo(rangeMin + (rangeMax - rangeMin) * rand.nextDouble());
			registros.add(r);
		}
		return registros;
	}

}
