package com.ies.curso.micronaut.tema15.front.client;


import java.util.List;

import com.ies.curso.micronaut.tema15.front.dto.Producto;
import com.ies.curso.micronaut.tema15.front.dto.ProductoRequest;


public interface ProductoOperations {

	List<Producto> listarProductos(String nombre,String marca, String sku, boolean activo);

	List<Producto> listarProductos(ProductoRequest req);
}
