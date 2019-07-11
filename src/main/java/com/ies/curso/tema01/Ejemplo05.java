package com.ies.curso.tema01;

import java.io.IOException;

public class Ejemplo05 {

	protected static class Clase1 {

		public String saludar(String nombre) {
			return "Hola " + nombre;
		}

		public String saludar(String titulo, String nombre) {
			return "Hola " + titulo + " " + nombre;
		}

		public String saludar(String titulo, String nombre, String propietario) {
			return saludar(titulo, nombre) + ", " + propietario;
		}
		
		public void arrojarCheckedException() throws IOException{
			throw new IOException("Ocurrió un error al procesar");
		}
		
		public void arrojarUnCheckedException() {
			throw new RuntimeException("Ocurrió un error en tiempo de ejecución");
		}
	}
	
	public static void main(String[] args) {
		Clase1 clase = new Clase1();
		System.out.println(clase.saludar("Juan"));
		System.out.println(clase.saludar("Ing.","Juan"));
		System.out.println(clase.saludar("ing.", "Juan","Señor de los tacos al pastor"));
		
		
		try {
			clase.arrojarCheckedException();
		} catch (IOException e) {
			System.out.println("Procesamos la excepción y nos arrojó "+e.getMessage());
		}
		
		clase.arrojarUnCheckedException();
		
	}
	

}
