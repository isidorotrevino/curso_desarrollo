package com.ies.curso.tema04.ejemplo01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class CalculadoraMd5Test {

	@Test
	public void calcularMd5Correcto() {
		CalculadoraMd5 calc = new CalculadoraMd5();
		String cadena = "Probar con junit es bien fácil";
		String hashEsperado = "50021D3CA4ED8E618954B5D1F3F38A34";
		String hashCalculado = calc.calcularMd5(cadena);
		assertEquals(hashEsperado, hashCalculado);
	}
	
	@Test
	public void calcularMd5Incorrecto() {
		CalculadoraMd5 calc = new CalculadoraMd5();
		String cadena = "Probar con junit es bien facil";
		String hashEsperado = "50021D3CA4ED8E618954B5D1F3F38A34";
		String hashCalculado = calc.calcularMd5(cadena);
		assertEquals(hashEsperado, hashCalculado);
	}
	
}
