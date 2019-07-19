package com.ies.curso.tema05.ejemplo02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"numeroSiniestro","noPoliza"})
public class BeanGenericoConLombok {

	@NonNull
	protected String numeroSiniestro;
	protected String general;
	@NonNull
	protected String noPoliza;
	protected String inciso;
	protected String numeroReporte;
	protected String nombreReportante;
	protected String telefonoReportante;
	protected String estado;
	protected String ciudad;
	protected String colonia;
	protected String cp;
	protected String calle;
	protected String tipo;
	protected String marca;
	protected String submarca;
	protected String version;
	protected String modelo;
	protected String placas;
	protected String noMotor;
	protected String color;
	protected String tipoServicio;
	protected String descripcion;
	protected String tipoUso;
	protected String estadoCirculacion;
	
}
