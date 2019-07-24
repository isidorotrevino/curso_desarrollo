package com.ies.curso.spring.tema08.ejemplo01.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.ies.curso.spring.tema08.ejemplo01.dto.CapitalCity;
import com.ies.curso.spring.tema08.ejemplo01.dto.CapitalCityResponse;
import com.ies.curso.spring.tema08.ejemplo01.service.CountryInfoService;

@Service
public class CountryInfoServiceImpl extends WebServiceGatewaySupport
implements CountryInfoService{

	@Override
	public String obtenerCapital(String codigoIso) {
		CapitalCity request = new CapitalCity(codigoIso);
		CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso", 
						request,new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo/CapitalCity"));
		return response.getCapital();
	}
	
	@PostConstruct
	protected void init() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("com.ies.curso.spring.tema08.ejemplo01.dto");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}

}
