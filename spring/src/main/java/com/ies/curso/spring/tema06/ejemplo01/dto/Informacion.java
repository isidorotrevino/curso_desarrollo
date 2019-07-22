package com.ies.curso.spring.tema06.ejemplo01.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Informacion {

	@NotNull
	@NotBlank
    @Size(min=2, max=30)
	protected String telefono;
	@NotNull
	@NotBlank
	protected String direccion;
}
