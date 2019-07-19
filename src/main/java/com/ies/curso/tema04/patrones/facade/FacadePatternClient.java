package com.ies.curso.tema04.patrones.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FacadePatternClient {

	private static int choice;

	public static void main(String args[]) throws NumberFormatException, IOException {

		do {
			System.out.print("========= Tienda de móviles ============ \n");
			System.out.print("            1. IPHONE.              \n");
			System.out.print("            2. SAMSUNG.              \n");
			System.out.print("            3. Salir.                     \n");
			System.out.print("Elija: ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			choice = Integer.parseInt(br.readLine());

			ShopKeeper sk = new ShopKeeper();

			switch (choice) {
			case 1:
				sk.iphoneSale();
				break;

			case 2:
				sk.samsungSale();
				break;

			

			default:
				System.out.println("Nada");
				return;
			}

		} while (choice != 3);

	}

}
