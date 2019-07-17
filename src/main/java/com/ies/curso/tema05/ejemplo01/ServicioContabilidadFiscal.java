package com.ies.curso.tema05.ejemplo01;

public class ServicioContabilidadFiscal implements ServicioContabilidad {

	@Override
	public void registrarAbono(String abono) {
		System.out.println("Realizando abono a cuenta de ventas con el registro de "+abono);
	}

	@Override
	public void prepararCierre() {
		System.out.println("Calculando utilidad fiscal y determinando ISR");
	}

}
