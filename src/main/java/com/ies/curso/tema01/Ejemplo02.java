package com.ies.curso.tema01;

public class Ejemplo02 {

	protected double param1;
	protected double param2;
	
	protected double dividir(double dividendo,double divisor) {
		return dividendo/divisor;
	}
	
	public String realizarDivision() {
		return "La división es " + dividir(param1,param2);
	}
	
	public Ejemplo02(double p1, double p2) {
		this.param1 = p1;
		this.param2 = p2;
	}
	
	/*
	 * El método main es un método especial que siempre será punto de entrada
	 * de ejecución de los programas
	 */	
	public static void main (String [] args) {
		Ejemplo02 e = new Ejemplo02(5.23,1.2);
		
		String resultado = e.realizarDivision();
		
		//La clase System nos provee utilerías para interactura con el entorno del SO
		System.out.println("El resultado es "+resultado);
	}
	
}
