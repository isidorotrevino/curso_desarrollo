package com.ies.curso.tema04.patrones.builder;

public class Pizza {

	protected String nombre;
	protected double valor;
	protected String tamaño;
	
	protected Pizza(String n, double v, String t) {
		this.nombre=n;
		this.valor=v;
		this.tamaño=t;
	}
	
	public static class Builder{
		protected String nombre;
		protected double valor;
		protected String tamaño;
		
		public Builder nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}
		public Builder valor(double valor) {
			this.valor = valor;
			return this;
		}
		public Builder tamaño(String tamaño) {
			this.tamaño = tamaño;
			return this;
		}
		
		public Pizza build() {
			return new Pizza(this.nombre,this.valor,this.tamaño);
		}
		
	}
	
}
