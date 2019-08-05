package com.ies.curso.micronaut.tema13.service

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

import com.ies.curso.micronaut.tema13.domain.Marca
import com.ies.curso.micronaut.tema13.domain.Producto

import grails.gorm.services.Service

@Service(Producto)
abstract class  ProductoService {

	abstract int count()
	
	abstract Producto save(@NotBlank String nombre,@NotBlank  String sku,
				  String marca,Boolean descontinuado)
	
	abstract List<Producto> findAll()
	
	abstract List<Producto> findAllByMarca(String marca)
	
	abstract List<Producto> findAllByMarcaIlike(String marca)
	
	abstract Producto find(@NotNull Long id)
	
	abstract Producto saveProducto(Producto producto)
	
	List<Producto> buscarProductos(String marca, String sku){
		def criteria = Producto.createCriteria()
		List productos = criteria.list{
			eq('marca',marca)
			if(sku!=null) {
				ilike('sku',sku+'%')
			}
			
		}
	}
}
