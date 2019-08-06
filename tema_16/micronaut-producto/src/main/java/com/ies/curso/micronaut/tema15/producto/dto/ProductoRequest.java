package com.ies.curso.micronaut.tema15.producto.dto;

public class ProductoRequest {

	protected String nombre;
	protected String sku;

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
}
