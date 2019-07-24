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
@XmlRootElement(name = "return",namespace="http://zurich.com.mx/cmp/integration/webservice/ike/api/IkeWebServiceAPI")
@XmlType(name = "return",namespace="http://zurich.com.mx/cmp/integration/webservice/ike/api/IkeWebServiceAPI",propOrder = {
    "responseCore"
})
@AllArgsConstructor
@NoArgsConstructor
public class ReturnCode {

	@XmlElement(name="responseCore",namespace="http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
	protected ResponseCore responseCore;

}
