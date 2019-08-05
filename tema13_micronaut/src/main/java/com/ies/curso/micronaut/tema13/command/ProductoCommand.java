package com.ies.curso.micronaut.tema13.command;

import javax.annotation.MatchesPattern;
import javax.annotation.RegEx;
import javax.validation.constraints.NotBlank;

public class ProductoCommand {

	@NotBlank
	protected String nombre;
	@NotBlank
	protected String sku;
	//@MatchesPattern(value = "[A-Z] {5}-\\d{10}")
	
	protected String marca;
	protected Boolean descontinuado;
	
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Boolean getDescontinuado() {
		return descontinuado;
	}
	public void setDescontinuado(Boolean descontinuado) {
		this.descontinuado = descontinuado;
	}
	
	
	
}
