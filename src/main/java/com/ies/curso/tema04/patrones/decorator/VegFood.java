package com.ies.curso.tema04.patrones.decorator;

public class VegFood implements Food {

	public String prepareFood() {
		return "Veg Food";
	}

	public double foodPrice() {
		return 50.0;
	}

}
