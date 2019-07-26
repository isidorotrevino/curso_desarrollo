package com.ies.curso.spring.tema10.ejemplo02.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class JwtAuthException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5192405681760662335L;
	private final String message;
	private final HttpStatus httpStatus;

	@Override
	public String getMessage() {
		return message;
	}
}
