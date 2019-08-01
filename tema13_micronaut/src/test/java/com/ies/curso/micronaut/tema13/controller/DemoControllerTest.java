package com.ies.curso.micronaut.tema13.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class DemoControllerTest {

	
	@Inject
    @Client("/")
	RxHttpClient client;

    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void testIndex() throws Exception {
        HttpRequest request = HttpRequest.GET("/demo"); 
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
        assertEquals(
                body,
                "HOLA MUNDO"
        );
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testHolaMundoJson() throws Exception {
    	HttpRequest request = HttpRequest.GET("/demo/holaMundoJson").accept(MediaType.APPLICATION_JSON_TYPE);    	
    	String body = client.toBlocking().retrieve(request);
    	ObjectMapper mapper = new ObjectMapper();
    	Map<?,?> mapa = mapper.readValue(body, Map.class);
    	assertNotNull(mapa);
    	assertEquals("valor1",mapa.get("llave1"));
    	assertEquals("valor2",mapa.get("llave2"));
    	assertEquals("valor3",mapa.get("llave3"));
    }
	
}
