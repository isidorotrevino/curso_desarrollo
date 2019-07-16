package com.ies.curso.tema02.ejemplo04;

public class Empleado {

	protected String nombre;
	protected double salario;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String toString() {
		return nombre+"["+salario+"]";
	}
	
}
