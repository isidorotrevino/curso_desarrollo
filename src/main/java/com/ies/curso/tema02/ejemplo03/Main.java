package com.ies.curso.tema02.ejemplo03;

public class Main {

	public static void main(String[] args) {
		Procesador proc = i -> i.toUpperCase();
		System.out.println(proc.procesar("hola mundo"));
		proc = input -> input.substring(0,4);
		System.out.println(proc.procesar("hola mundo"));
		proc = entrada ->{
			String[] partes = entrada.split(" ");
			StringBuilder builder = new StringBuilder();
			for(String p : partes) {
				if(p.length()>4) {
					builder.append(p.toUpperCase());
				}
				else {
					builder.append(p.toLowerCase());
				}
				builder.append(" ");
			}
			return builder.toString().trim();
		};
		System.out.println(proc.procesar("hola mundo"));
	}

	
	
}
