package com.ies.curso.tema05.ejemplo01;

public class ServicioControl {

	protected ServicioContabilidad servicioContabilidad;
	protected ServicioAdministracion servicioAdministracion;
	
	/**
	 * Inyección de dependencias mediante constructor
	 * @param servicioContabilidad
	 */
	public ServicioControl(ServicioAdministracion servicioAdministracion) {
		if(servicioAdministracion==null) {
			throw new IllegalArgumentException(" No podemos trabajar sin un servicio de administración");
		}
		this.servicioAdministracion=servicioAdministracion;
	}

	public void setServicioContabilidad(ServicioContabilidad servicioContabilidad) {
		this.servicioContabilidad = servicioContabilidad;
	}
	
	public void prepararContabilidad() {
		if(this.servicioContabilidad!=null) {
			this.servicioContabilidad.prepararCierre();
		}
		else {
			throw new IllegalArgumentException(" No podemos trabajar sin un servicio contable ");
		}
	}
	
	public void venderProductos(String... productos) {
		for(String producto : productos) {
			this.servicioAdministracion.registrarVenta(producto);
		}
		
	}
	
}
