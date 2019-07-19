package com.ies.curso.tema04.patrones.singleton;

public class Singleton {

	private static Singleton elSingleton;
	private static boolean singletonDisponible = true;

	private Singleton() {
	}

	public static Singleton getElSingleton() {
		//Codigo fuera del synchronized
		//....
		//....
		synchronized (elSingleton) {
			if (singletonDisponible) {
				if (elSingleton == null) {
					elSingleton = new Singleton();
				}
				singletonDisponible = false;
				return elSingleton;
			} else {
				return null;
			}
		}
	}

	public String toString() {
		return "Devolvemos nuestra instancia de Singleton!";
	}

	public void limpiarSingleton() {
		singletonDisponible = true;
	}
}
