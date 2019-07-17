package com.ies.curso.tema05.ejemplo01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Preparamos un control con servicios de contabilidad financiera");
		
		ServicioControl control = new ServicioControl(new ServicioAdministracionImpl());
		control.setServicioContabilidad(new ServicioContabilidadFinanciera());
		
		control.venderProductos("Refresco","Café","Agua embotellada","Vino");
		control.prepararContabilidad();
		
		System.out.println("Preparamos un control con servicios de contabilidad fiscal");
		control.setServicioContabilidad(new ServicioContabilidadFiscal());
		control.prepararContabilidad();
	}

}
