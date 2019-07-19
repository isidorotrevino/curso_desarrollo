package com.ies.curso.tema04.patrones.builder;

public class Pizza {

	protected String nombre;
	protected double valor;
	protected String tamaño;
	
	protected Pizza(String n, double v, String t) {
		this.nombre=n.toUpperCase();
		this.valor=v;
		this.tamaño=t;
	}
	
	public String toString() {
		return "NOMBRE="+nombre+" VALOR=$" +valor+ " TAMAÑO="+tamaño;
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
			if(this.nombre==null) {
				throw new IllegalArgumentException("No puedes crear una pizza sin nombre");
			}
			return new Pizza(this.nombre,this.valor,this.tamaño);
		}
		
	}
	
}
