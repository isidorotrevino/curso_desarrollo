package com.ies.curso.tema04.patrones.facade;
public class Samsung implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println(" Samsung galaxy tab 3 ");
		
	}

	@Override
	public void price() {
		 System.out.println(" $ 45000.00 ");
		
	}

}
