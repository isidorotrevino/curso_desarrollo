package com.ies.curso.spring.tema08.ejemplo01.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CapitalCity",namespace="http://www.oorsprong.org/websamples.countryinfo")
@XmlType(name = "CapitalCity",namespace="http://www.oorsprong.org/websamples.countryinfo",
propOrder = {
    "codigoPais"
})
public class CapitalCity {
	
	@XmlElement(name="sCountryISOCode",
				namespace="http://www.oorsprong.org/websamples.countryinfo")
	protected String codigoPais;
	
}
