package com.ies.curso.tema05.ejemplo01;

public class ServicioContabilidadFinanciera implements ServicioContabilidad{

	@Override
	public void registrarAbono(String abono) {
		System.out.println("Registrando abono contable");
	}

	@Override
	public void prepararCierre() {
		System.out.println("Realizando conciliaciones y preparando cierre");
	}

}
