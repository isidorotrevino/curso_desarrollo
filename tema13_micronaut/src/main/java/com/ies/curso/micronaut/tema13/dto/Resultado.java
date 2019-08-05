package com.ies.curso.micronaut.tema13.dto;


public class Resultado<T> {

	private boolean exito;
	private String mensaje;
	private T resultado;
	public boolean isExito() {
		return exito;
	}
	public void setExito(boolean exito) {
		this.exito = exito;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getResultado() {
		return resultado;
	}
	public void setResultado(T resultado) {
		this.resultado = resultado;
	}
	
	
}
