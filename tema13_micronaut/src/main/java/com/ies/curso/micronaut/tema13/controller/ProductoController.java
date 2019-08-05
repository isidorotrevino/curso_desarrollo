package com.ies.curso.micronaut.tema13.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.ies.curso.micronaut.tema13.command.ProductoCommand;
import com.ies.curso.micronaut.tema13.domain.Producto;
import com.ies.curso.micronaut.tema13.dto.Resultado;
import com.ies.curso.micronaut.tema13.service.ProductoService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

@Validated
@Controller("/producto")
public class ProductoController {

	protected ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	@Get("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> listarProductos(){
		return productoService.findAll();
	}
	
	@Get("/buscar/{marca}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> listarProductos(String marca){
		return productoService.findAllByMarcaIlike(marca+"%");
	}
	
	@Get("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HttpResponse<Resultado<Producto>> obtenerProductos(Long id){
		Producto producto =productoService.find(id);
		Resultado<Producto> resultado = new Resultado<>();
		if(producto!=null) {
			resultado.setExito(true);
			resultado.setMensaje("Operacion exitosa");
			resultado.setResultado(producto);
			return HttpResponse.ok(resultado);
		}
		else {
			resultado.setExito(false);
			resultado.setMensaje("No hay producto");
			return HttpResponse.notFound(resultado);
		}
	}
	
	@Post("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto crearProducto(@Valid @Body ProductoCommand command) {
		Producto producto = productoService.save(command.getNombre(), command.getSku(), command.getMarca(), command.getDescontinuado());
	
		return producto;
	}
	
	@Put("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto crearProducto(Long id,@Valid @Body ProductoCommand command) {
		
		Producto producto = productoService.find(id);
		if(producto!=null) {
			producto.setNombre(command.getNombre());
			producto.setSku(command.getSku());
			producto.setMarca(command.getMarca());
			producto = productoService.saveProducto(producto);
		}
				
		return producto;
	}
	
	@PostConstruct
	public void init() {
		for(int i=0;i<5;i++) {
			Producto producto = new Producto();
			producto.setMarca("Marca"+i);
			producto.setSku("AAAABBBB"+i);
			producto.setDescontinuado(false);
			producto.setNombre("Producto "+i);
			productoService.saveProducto(producto);
		}
	}
	
}
