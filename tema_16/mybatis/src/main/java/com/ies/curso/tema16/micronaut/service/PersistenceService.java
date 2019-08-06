package com.ies.curso.tema16.micronaut.service;

import java.util.List;
import java.util.Map;

import com.ies.curso.tema16.micronaut.dto.Filtro;
import com.ies.curso.tema16.micronaut.dto.Registro;

public interface PersistenceService {

    public List<Map<String,Object>> obtenerDatosPrueba();

    public List<Registro> obtenerRegistrosFiltrado(Long idInicial,Long idFinal);

    public List<Registro> obtenerRegistrosAvanzado(Filtro filtro);
}
