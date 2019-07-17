package com.ies.curso.tema04.patrones.builder;

public class Main {

	public static void main(String[] args) {
		Pizza.Builder builder = new Pizza.Builder();
		builder = builder.nombre("Hawaiiana");
		builder = builder.valor(25f);
		builder = builder.tamaño("Grande");
		Pizza hawaiiana = builder.build();
		
		builder = new Pizza.Builder();
		builder = builder.nombre("Pepperoni");
		builder = builder.tamaño("Grande");
		Pizza promocion = builder.build();
	}
	
}
