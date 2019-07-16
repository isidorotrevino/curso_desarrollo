package com.ies.curso.tema02.ejemplo04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	protected static String[] nombres = {"Juan","Pedro","Sofía","Fernando","Lucía","Miguel","Francisco",
			"Angélica","Saúl","Ana","María","Isaac","Iván","Edgar","Roberto","Gilberto"};
	
	protected static String[] apellidos = {"Jimenez","López","Rodríguez","Martínez","Pérez","Hidalgo",
			"Flores","Treviño"};
	
	public static List<Empleado> generarEmpleados(){
		Random r = new Random();
		double rangeMin=10000;
		double rangeMax=100000;
		List<Empleado> l = new ArrayList<>();
		for(String n : nombres) {
			for(String a : apellidos) {
				Empleado e = new Empleado();
				e.setNombre(n+" "+a);
				double salario = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				e.setSalario(salario);
				l.add(e);
			}
		}
		return l;
	}
	
}
