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
@XmlRootElement(name = "CapitalCityResponse",namespace="http://www.oorsprong.org/websamples.countryinfo")
@XmlType(name = "CapitalCityResponse",namespace="http://www.oorsprong.org/websamples.countryinfo",
propOrder = {
    "capital"
})
public class CapitalCityResponse {
	
	@XmlElement(name="CapitalCityResult",
			namespace="http://www.oorsprong.org/websamples.countryinfo")
	protected String capital;
}
