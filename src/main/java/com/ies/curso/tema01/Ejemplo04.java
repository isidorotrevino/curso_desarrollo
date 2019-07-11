package com.ies.curso.tema01;

public class Ejemplo04 {

	protected interface Auto{
		
		public String obtenerModelo();
		
		default void encender() {
			System.out.println("Encendiendo motor");
		}		
	}
	
	protected static abstract class Volkswagen implements Auto{
		
		public abstract void encenderRadio();
	}
	
	protected static class Beetle extends Volkswagen{

		@Override
		public String obtenerModelo() {
			return "Beetle";
		}

		@Override
		public void encenderRadio() {
			System.out.println("Sintonizando FM");
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Creando un Volkswagen");
		
		Auto vw = new Beetle();
		vw.encender();
		System.out.println("Estamos manejando un "+vw.obtenerModelo());
		Beetle b = (Beetle) vw; // No podemos asignar una variable de x tipo a su tipo padre de manera simple, hay que hacer cast
		b.encenderRadio();
		
		System.out.println("Creando un Chevrolet a través de una clase anónima");
		Auto aveo = new Auto() {			
			@Override
			public String obtenerModelo() {				
				return "Chevrolet Aveo";
			}
		};
		
		aveo.encender();
		System.out.println("Estamos manejando un "+aveo.obtenerModelo());
	}
	
}
