package com.ies.curso.micronaut.tema13.domain

import grails.gorm.annotation.Entity

@Entity
class Producto {

	String nombre
	String sku
	String marca
	Boolean descontinuado=false;
	
	static constraints = {
		marca (nullable:true)
	}
}
