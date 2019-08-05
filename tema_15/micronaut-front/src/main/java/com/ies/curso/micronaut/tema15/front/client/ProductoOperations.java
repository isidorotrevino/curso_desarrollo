package com.ies.curso.micronaut.tema15.front.client;


import com.ies.curso.micronaut.tema15.front.dto.Producto;

import io.reactivex.Flowable;

public interface ProductoOperations {

	Flowable<Producto> findAll();

	
}
