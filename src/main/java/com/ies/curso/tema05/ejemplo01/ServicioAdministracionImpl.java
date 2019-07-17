package com.ies.curso.tema05.ejemplo01;

public class ServicioAdministracionImpl implements ServicioAdministracion {

	@Override
	public void registrarVenta(String venta) {
		System.out.println("Registrando Venta de "+venta);
	}

}
