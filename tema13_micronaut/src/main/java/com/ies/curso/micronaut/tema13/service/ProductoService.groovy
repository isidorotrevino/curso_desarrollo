package com.ies.curso.micronaut.tema13.service

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

import com.ies.curso.micronaut.tema13.domain.Producto

import grails.gorm.services.Service

@Service(Producto)
interface  ProductoService {

	int count()
	
	Producto save(@NotBlank String nombre,@NotBlank  String sku,
				  String marca,Boolean descontinuado)
	
	List<Producto> findAll()
	
	List<Producto> findAllByMarca(String marca)
	
	Producto find(@NotNull Long id)
	
	Producto saveProducto(Producto producto)
}
