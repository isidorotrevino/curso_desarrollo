package com.ies.curso.tema04.patrones.observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler2 implements Observer {
	private String resp;

	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			resp = (String) arg;
			System.out.println("\nReceived Response 2: " + resp);
		}
	}
}