package com.ies.curso.spring.tema07.ejemplo02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.curso.spring.tema07.ejemplo02.api.AssignLegalAdviser;
import com.ies.curso.spring.tema07.ejemplo02.api.LegalAdviserAssignmentRequest;
import com.ies.curso.spring.tema07.ejemplo02.api.LegalAdviserAssignmentResponse;
import com.ies.curso.spring.tema07.ejemplo02.api.ResponseCore;
import com.ies.curso.spring.tema07.ejemplo02.api.ReturnCode;

@RestController
@RequestMapping("/complex")
public class WeirdApiController {

	@GetMapping(path="/request",produces = "text/xml")
	public AssignLegalAdviser getRequest() {
		return new AssignLegalAdviser(
				new LegalAdviserAssignmentRequest("CLAIM-001","SOON",
						"EXP-001","LAWYER-001","SERVICE-001"));
	}
	
	@GetMapping(path="/response",produces = "text/xml")
	public LegalAdviserAssignmentResponse getResponse() {
		return new LegalAdviserAssignmentResponse(
				new ReturnCode(new ResponseCore(200,"EXITO","STATUS OK")));
	}
	
}
