package com.ies.curso.tema16.micronaut.controller;

import io.micronaut.http.annotation.*;

import javax.annotation.Nullable;

import com.ies.curso.tema16.micronaut.dto.Filtro;
import com.ies.curso.tema16.micronaut.dto.Registro;
import com.ies.curso.tema16.micronaut.service.PersistenceService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller("/demo")
public class DemoController {

    protected PersistenceService persistenceService;

    public DemoController(PersistenceService persistenceService){
        this.persistenceService = persistenceService;
    }

    @Get("/")
    public List<Map<String,Object>> obtenerDatosPrueba(){
        return persistenceService.obtenerDatosPrueba();
    }

    @Get("/buscarFiltrado")
    public List<Registro> obtenerDatosFiltrados(@QueryValue Long idInicial, @QueryValue Long idFinal){
        return persistenceService.obtenerRegistrosFiltrado(idInicial,idFinal);
    }

    @Post("/buscarAvanzado")
    public List<Registro> obtenerDatosFiltroAvanzado(@Body Filtro filtro){
        return persistenceService.obtenerRegistrosAvanzado(filtro);
    }
}
