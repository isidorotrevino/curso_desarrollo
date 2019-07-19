package com.ies.curso.tema05.ejemplo02;

public class Main {

	public static void main(String[] args) {
		System.out.println("Creamos un bean sin lombok");
		BeanGenericoSinLombok sinL = new BeanGenericoSinLombok();
		sinL.setAmaternoConductor("Prueba");
		sinL.setApaternoConductor("L");
		sinL.setAvisoPrivacidad(true);
		sinL.setCorreoConductor("L");
		sinL.setCurpConductor("L");
		sinL.setDeclaracion("L");
		sinL.setEdadConductor("L");
		sinL.setFirmaAjustador("L");
		sinL.setFirmaConductor("L");	
		System.out.println("Probamos los métodos básicos:");
		System.out.println("To String: "+sinL.toString());
		System.out.println("Hashcode: "+sinL.hashCode());
		
		System.out.println("Creamos un bean con lombok (via su builder)");
		BeanGenericoConLombok conL = BeanGenericoConLombok.builder()
				.calle("calle")
				.ciudad("ciudad")
				.colonia("colonia")
				.color("rojo")
				.cp("06700")
				.descripcion("L")
				.estado("L")
				.general("L")
				.noPoliza("L")
				.numeroSiniestro("NUM SINIESTRO")
				.noPoliza("AABBBDSFDDASF0001")
				.build();
		
		System.out.println("Probamos los métodos básicos:");
		System.out.println("To String: "+conL.toString());
		System.out.println("Hashcode: "+conL.hashCode());		
	}

}
