package com.ies.curso.tema02.ejemplo04;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Empleado> empleados = Util.generarEmpleados();

		System.out.println("Obtenemos todos los empleados que ganen más de 50,000");
		List<Empleado> empleadosFiltrados = empleados.stream().filter(p -> p.getSalario() >= 50000)
				.collect(Collectors.toList());
		System.out.println(empleadosFiltrados.size()+"="+empleadosFiltrados);
		
		System.out.println("Obtenemos los diferentes apellidos de los empleados");
		List<String> apellidos = empleados.stream().map(p -> {
			String[] partes = p.getNombre().split(" ");
			return partes[1];
		}).distinct().sorted().collect(Collectors.toList());
		System.out.println(apellidos.size()+"="+apellidos);
	}
}
