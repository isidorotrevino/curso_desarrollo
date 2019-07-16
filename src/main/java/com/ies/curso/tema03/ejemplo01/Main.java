package com.ies.curso.tema03.ejemplo01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Classloader of Main:"
		        + Main.class.getClassLoader());
		System.out.println("Classloader of String:"
		        + String.class.getClassLoader());
	}
	
}
