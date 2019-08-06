package com.ies.curso.micronaut.tema15.producto.controller;

import java.util.Arrays;
import java.util.List;

import com.ies.curso.micronaut.tema15.producto.dto.Producto;
import com.ies.curso.micronaut.tema15.producto.dto.ProductoRequest;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.NewSpan;

@Controller("/productos")
public class ProductosController {

	@Get("/")
	@ContinueSpan
	List<Producto> listarProductos(
			@Parameter String nombre,
			@Parameter String marca, 
			@Parameter String sku, 
			@Parameter boolean activo) {
		Producto misterio= new Producto(nombre, marca,sku,activo);
		Producto palomitas = new Producto("Palomitas", "Act One","PAL123",false);
		Producto papas = new Producto("Adobadas", "Sabritas","PAP123",false);
		Producto refresco = new Producto("Coca Light", "Coca Cola","COC123",false);
		return Arrays.asList(palomitas, papas, refresco,misterio);
	}
	
	@ContinueSpan()
	@NewSpan("consultandoRegaloEspecial")
	@Post("/especial")
	List<Producto> listarProductos(ProductoRequest req){
		Producto misterio= new Producto(req.getNombre(), "",
				req.getSku(),false);
		return Arrays.asList(misterio);
	}
//	@Error(status = HttpStatus.BAD_REQUEST)
//	String manejarError(RuntimeException e) {
//	return "";	
//	}
}
