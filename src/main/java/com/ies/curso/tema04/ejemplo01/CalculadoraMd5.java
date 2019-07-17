package com.ies.curso.tema04.ejemplo01;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class CalculadoraMd5 {

	public String calcularMd5(String cadena) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(cadena.getBytes());
			byte[] digest = md.digest();
		    String hash = DatatypeConverter
		      .printHexBinary(digest).toUpperCase();
		    return hash;
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Ocurrió un problema", e);
		}
	}

}
