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
@XmlRootElement(name = "legalAdviserAssignmentRequest", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/api/IkeWebServiceAPI")
@XmlType(name = "legalAdviserAssignmentRequest", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/api/IkeWebServiceAPI", propOrder = {
		"claimNumber", "estimatedArrivalTime", "expedientNumber", "lawyerName", "serviceNumber" })
@NoArgsConstructor
@AllArgsConstructor
public class LegalAdviserAssignmentRequest {

	@XmlElement(name = "claimNumber", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
	protected String claimNumber;
	@XmlElement(name = "estimatedArrivalTime", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
	protected String estimatedArrivalTime;
	@XmlElement(name = "expedientNumber", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
	protected String expedientNumber;
	@XmlElement(name = "lawyerName", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
	protected String lawyerName;
	@XmlElement(name = "serviceNumber", namespace = "http://zurich.com.mx/cmp/integration/webservice/ike/customrequest")
	protected String serviceNumber;

}
