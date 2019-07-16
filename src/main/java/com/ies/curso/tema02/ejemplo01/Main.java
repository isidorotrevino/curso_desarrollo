package com.ies.curso.tema02.ejemplo01;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Lectura de archivo");
		try (FileInputStream input = new FileInputStream("src/main/resources/input.txt")) {
			int content;
			while ((content = input.read()) != -1) {
				System.out.print((char) content);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Escritura de archivo");
		try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("textfile.txt"))) {
			stream.write("Hola, Mundo!".getBytes());
            stream.write(System.lineSeparator().getBytes());
            stream.write("Escribiendo un texto random a un arreglo de bytes".getBytes());
            for(int i=0;i<25000;i++) {
            	if(i%100==0) {
            		stream.write("\n".getBytes());
            	}
            	stream.write(String.valueOf(i).getBytes());
            }
            stream.write(System.lineSeparator().getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fin");
	}

}
