package com.ies.curso.micronaut.tema14.seguridad.controller;

import java.security.Principal;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;

@Secured("isAuthenticated()") // <1>
@Controller("/")  // <2>
public class DemoController {

	
    @Get(value="/")  // <3>
    String index(Principal principal) {  // <4>
        return principal.getName();
    }
    
    @Secured("isAnonymous()")
    @Get(value="/hola")
    String holaMundo() {
    	return "HOLA MUNDO";
    }
}
