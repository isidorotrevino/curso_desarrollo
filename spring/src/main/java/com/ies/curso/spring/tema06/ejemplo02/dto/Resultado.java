package com.ies.curso.spring.tema06.ejemplo02.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Resultado")
public class Resultado {

	protected Long id;
	protected boolean exito;
	protected String mensaje;
	
}
