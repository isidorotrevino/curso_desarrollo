package com.ies.curso.micronaut.tema13.domain

import grails.gorm.annotation.Entity

@Entity
class Marca {
	
	String nombre
	
	
	// objetoMarca.productos = []
	static hasMany= [productos:Producto]
	
	static mapping = {
//		if(ambiente=='prod') {
//			table 'PROD_MARCA'
//		}
		
	}
}
