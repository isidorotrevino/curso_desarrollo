package com.ies.curso.tema04.ejemplo01;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculadoraContabilidadTest {

	@Mock 
	ContabilidadService contabilidadService;
	
	CalculadoraContabilidad calculadoraContabilidad;
	
	LocalDate fechaInicio = LocalDate.now().minusMonths(3);
	
	LocalDate fechaFin = LocalDate.now();
	
	@BeforeEach
	void init() {
		calculadoraContabilidad = new CalculadoraContabilidad();
		
		calculadoraContabilidad.setContabilidadService(contabilidadService);
		   
	    Mockito.lenient()
	    	.when(contabilidadService.obtenerRegistrosPeriodo(fechaInicio, fechaFin))
	    	.thenReturn(obtenerRegistros());
	        
	}
	
	@Test
	public void probarCalculoSaldo() {
		Double saldo = calculadoraContabilidad.obtenerSaldoPeriodo(fechaInicio, fechaFin);
		System.out.println("Saldo obtenido "+saldo);
		assertTrue(saldo>=0.0d);
	}
	
	protected List<RegistroContable> obtenerRegistros(){
		List<RegistroContable> registros = new ArrayList<>();
		for(int i=1;i<=500;i++) {
			RegistroContable r = new RegistroContable();
			r.setAbono((double)i*10000);
			r.setCargo((double)i*5000);
			registros.add(r);
		}
		return registros;
	}
	
}
