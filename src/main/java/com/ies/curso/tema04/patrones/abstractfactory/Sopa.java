package com.ies.curso.tema04.patrones.abstractfactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Sopa {
	protected List<String> ingredientes = new ArrayList<>();
	protected String nombre;

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		StringBuilder stringIngredientes = new StringBuilder(nombre);
		stringIngredientes.append(" Ingredientes: ");
		Iterator iterator = ingredientes.iterator();
		while (iterator.hasNext()) {
			stringIngredientes.append(iterator.next());
		}
		return stringIngredientes.toString();
	}

}
