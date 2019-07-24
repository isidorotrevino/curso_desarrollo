package com.ies.curso.spring.tema08.ejemplo03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	protected Integer id;
	protected Double precio;
	protected String nombre;
	
}
