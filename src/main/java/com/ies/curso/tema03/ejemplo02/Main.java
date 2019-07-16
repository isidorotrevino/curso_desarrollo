package com.ies.curso.tema03.ejemplo02;

public class Main {

	public static void main(String[] args) {
		//Para tener acceso a las variables de ambiente se utiliza
		//la instrucción System.getenv
		System.out.println("JAVA_HOME="+System.getenv("JAVA_HOME"));
		System.out.println("PATH="+System.getenv("PATH"));
		
		//Para tener acceso a las propiedades, se utiliza
		//System.getProperty
		System.out.println("user.dir="+System.getProperty("user.dir"));
		System.out.println("java.class.path="+System.getProperty("java.class.path"));
		System.out.println("os.name="+System.getProperty("os.name"));
		System.out.println("os.arch="+System.getProperty("os.arch"));
	}

}
