package com.ies.curso.tema04.patrones.builder;

public class Main {

	public static void main(String[] args) {
		Pizza.Builder builder = new Pizza.Builder();
		builder = builder.nombre("Hawaiiana")
				.valor(25f)
				.tamaño("Grande");
		Pizza hawaiiana = builder.build();
		
		System.out.println("HAWAIIANA= "+hawaiiana);
		
		Pizza promocion = new Pizza.Builder()
				.nombre("Pepperoni")
				.tamaño("Grande")
				.build();
		
//		Pizza sorpresa = new Pizza.Builder()
//				.tamaño("Pequeña")
//				.valor(15).build();
//		
		System.out.println("PROMOCION "+promocion.toString());
	}
	
}
