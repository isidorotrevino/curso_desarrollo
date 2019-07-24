package com.ies.curso.spring.tema07.ejemplo02.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "responseCore",namespace="http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
@XmlType(name = "responseCore",namespace="http://zurich.com.mx/cmp/integration/webservice/ike/customrequest",propOrder = {
    "code","message","status"
})
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCore {

	@XmlElement(name="code",namespace="http://zurich.com.mx/cmp/integration/webservice/common")
	protected int code;
	@XmlElement(name="message",namespace="http://zurich.com.mx/cmp/integration/webservice/common")
	protected String message;
	@XmlElement(name="status",namespace="http://zurich.com.mx/cmp/integration/webservice/common")
	protected String status;
}
