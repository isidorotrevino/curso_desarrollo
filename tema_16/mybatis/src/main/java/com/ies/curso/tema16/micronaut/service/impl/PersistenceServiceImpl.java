package com.ies.curso.tema16.micronaut.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ies.curso.tema16.micronaut.dto.Filtro;
import com.ies.curso.tema16.micronaut.dto.Registro;
import com.ies.curso.tema16.micronaut.service.PersistenceService;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class PersistenceServiceImpl implements PersistenceService {

    protected SqlSessionFactory sqlSessionFactory;

    public PersistenceServiceImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Map<String, Object>> obtenerDatosPrueba() {
        SqlSession session = sqlSessionFactory.openSession();
        List<Map<String, Object>> resultados = null;
        try{

            resultados =session.selectList("com.ies.curso.dia5.PruebaReactive.obtenerRegistros");
        }finally{
            session.close();
        }
        return resultados;
    }

    @Override
    public List<Registro> obtenerRegistrosFiltrado(Long idInicial, Long idFinal) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("idInicial",idInicial);
        parametros.put("idFinal",idFinal);
        List<Registro> resultados = null;
        try(SqlSession session = sqlSessionFactory.openSession()){
            resultados =session.selectList("com.ies.curso.dia5.PruebaReactive.obtenerRegistrosFiltrado",parametros);
        }
        return resultados;
    }

    @Override
    public List<Registro> obtenerRegistrosAvanzado(Filtro filtro) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Registro> resultados = null;
        try{
            resultados =session.selectList("com.ies.curso.dia5.PruebaReactive.obtenerRegistrosFiltradoAvanzado",filtro);
        }finally{
            session.close();
        }
        return resultados;
    }
}
