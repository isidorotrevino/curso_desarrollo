package com.ies.curso.micronaut.tema15.front.client;


import com.ies.curso.micronaut.tema15.front.dto.Producto;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("http://localhost:8081")
public interface ProductoClient extends ProductoOperations {

    @Get("/productos")
    Flowable<Producto> findAll();
}
