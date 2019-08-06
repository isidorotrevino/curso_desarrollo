package com.ies.curso.micronaut.tema15.front.client;


import java.util.List;

import com.ies.curso.micronaut.tema15.front.dto.Producto;
import com.ies.curso.micronaut.tema15.front.dto.ProductoRequest;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("producto")
public interface ProductoClient extends ProductoOperations {

    @Get("/productos")
    List<Producto> listarProductos(
    		@QueryValue String nombre,
    		@QueryValue String marca, 
    		@QueryValue String sku, 
    		@QueryValue boolean activo);
    
    @Post("/productos/especial")
    List<Producto> listarProductos(ProductoRequest req);
}
