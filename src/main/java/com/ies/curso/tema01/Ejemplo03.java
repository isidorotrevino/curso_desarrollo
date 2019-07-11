package com.ies.curso.tema01;

public class Ejemplo03 {

	protected static class MotorGasolina {
		private int cilindros = 4; // Podemos inicializar los atributos
		protected String sonido;

		public MotorGasolina() { 			
		}
		//Podemos declarar múltiples constructores
		public MotorGasolina(int cilindros) {
			this.cilindros = cilindros;
			System.out.println("Creando un motor de gasolina de " + this.cilindros + " cilindros");
		}

		public String getSonido() {
			return sonido;
		}

		public void setSonido(String sonido) {
			this.sonido = sonido;
		}
	}

	protected static class MotorAlcohol extends MotorGasolina {
		public MotorAlcohol(int cilindros) {
			super(cilindros); // Invocamos el constructor de MotorGasolina
			System.out.println("Creamos un motor que corre con gasolina y alcohol");
		}
	}

	protected static class MotorDiesel extends MotorGasolina {
		public MotorDiesel(String sonido) {
			this.setSonido(sonido);
			System.out.println("Creamos un motor diesel") ;
		}
		
	}

	public static void main(String[] args) {
		MotorGasolina g = new MotorGasolina(6);
		
		g.setSonido("BRUUMMMM");
		System.out.println("El motor de gasolina hace " + g.getSonido());
		System.out.println();
		
		MotorAlcohol a = new MotorAlcohol(4);
		a.setSonido("RUUNN");
		System.out.println("El motor de alcohol hace " + a.getSonido());
		System.out.println();
		
		MotorDiesel d = new MotorDiesel("GRRRRR");
		System.out.println("El motor diesel hace " + d.getSonido());
	}

}
