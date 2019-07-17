package com.ies.curso.tema04.patrones.abstractfactory;

public class FabricaSopa {

	public SopaPollo prepararSopaPollo() {
		return new SopaPollo();
	}
	public Minestrone prepararSopaMinestrone() {
		return new Minestrone();
	}
	public Vegetales prepararSopaVegetales() {
		return new Vegetales();
	}
	
	
}
