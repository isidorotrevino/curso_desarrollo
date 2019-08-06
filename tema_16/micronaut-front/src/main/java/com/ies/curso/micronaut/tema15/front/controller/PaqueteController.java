package com.ies.curso.micronaut.tema15.front.controller;

import java.security.Principal;
import java.util.List;

import com.ies.curso.micronaut.tema15.front.client.ProductoOperations;
import com.ies.curso.micronaut.tema15.front.dto.Paquete;
import com.ies.curso.micronaut.tema15.front.dto.Producto;
import com.ies.curso.micronaut.tema15.front.dto.ProductoRequest;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.NewSpan;
import io.reactivex.Single;


@Controller("/paquetes")
public class PaqueteController {

	private final ProductoOperations productoOperations;

	public PaqueteController(ProductoOperations productoOperations) {
		this.productoOperations = productoOperations;
	}

	@NewSpan(value = "consultarProductos")
	@Get("/")
	public Paquete index(@Parameter String nombre,
			@Parameter String marca, @Parameter String sku, 
			@Parameter boolean activo) {
		Paquete paquete = new Paquete();
		paquete.setNombre("Paquete Atasques");
		System.out.println("PARAMS "+nombre + " "+marca + " "+ sku+" "+ activo);
		List<Producto> productos =	productoOperations.listarProductos(nombre, marca,
				sku, activo);
		paquete.setProductos(productos);
		System.out.println("PRODUCTOS "+paquete.getProductos());
		return paquete;
	}
	
	@NewSpan("consultarRegalo")
	@Get("/regalo")
	public Paquete paqueteRegalo() {
		Paquete paquete = new Paquete();
		paquete.setNombre("Paquete De Regalo");
		ProductoRequest req = new ProductoRequest();
		req.setNombre("Muñeco Buzz Lightyear");
		req.setSku("BUZZ123");
		List<Producto> productos = productoOperations.listarProductos(req);
		paquete.setProductos(productos);
		return paquete;
	}

	@NewSpan()
	@Get("/principal")
	String index(Principal principal) {
		return principal.getName();
	}
}
