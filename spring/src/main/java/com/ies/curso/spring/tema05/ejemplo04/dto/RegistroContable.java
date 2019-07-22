package com.ies.curso.spring.tema05.ejemplo04.dto;


public class RegistroContable {

//	@JsonProperty(value = "cuenta-contable")
	protected String cuenta;
	protected Double cargo;
	protected Double abono;
	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public Double getCargo() {
		return cargo;
	}
	public void setCargo(Double cargo) {
		this.cargo = cargo;
	}
	public Double getAbono() {
		return abono;
	}
	public void setAbono(Double abono) {
		this.abono = abono;
	}
	
}
