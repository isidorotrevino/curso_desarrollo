package com.ies.curso.tema04.patrones.abstractfactory;

public class Main {
	public static void main(String[] args) {
		FabricaSopa fab = new FabricaSopa();

		System.out.println("La sopa del día es "+fab.prepararSopaVegetales().getNombre() );


	}
}
