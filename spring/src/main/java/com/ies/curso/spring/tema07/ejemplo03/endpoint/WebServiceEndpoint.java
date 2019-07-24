package com.ies.curso.spring.tema07.ejemplo03.endpoint;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ies.curso.spring.tema07.ejemplo01.dto.ConsultaDocumento;
import com.ies.curso.spring.tema07.ejemplo01.dto.ConsultaDocumentoResponse;
import com.ies.curso.spring.tema07.ejemplo01.dto.Documento;
import com.ies.curso.spring.tema07.ejemplo01.dto.ObjectFactory;
import com.ies.curso.spring.tema07.ejemplo01.dto.SalidaConsulta;

@Endpoint
public class WebServiceEndpoint {

	public static final String NAMESPACE_URI = "http://www.openuri.org/";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ConsultaDocumento")
	@ResponsePayload
	public ConsultaDocumentoResponse consultarDocumento(@RequestPayload ConsultaDocumento request) {
		ObjectFactory factory = new ObjectFactory();
		ConsultaDocumentoResponse response = factory.createConsultaDocumentoResponse();
		SalidaConsulta salida = factory.createSalidaConsulta();
		response.setConsultaDocumentoResult(salida);
		salida.setClave("CLAVE");
		salida.setDescripcion("DESCRIPCION");
		salida.setExito(true);
		List<Documento> documentos = salida.getDocumento();
		Documento doc = factory.createDocumento();
		doc.setContenido(new byte[0]);
		doc.setNombre("DOCUMENTO");
		documentos.add(doc);

		return response;
	}
}
