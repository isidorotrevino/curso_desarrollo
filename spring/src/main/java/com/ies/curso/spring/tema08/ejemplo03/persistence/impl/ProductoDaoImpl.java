package com.ies.curso.spring.tema08.ejemplo03.persistence.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema08.ejemplo03.dto.Producto;
import com.ies.curso.spring.tema08.ejemplo03.persistence.ProductoMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductoDaoImpl implements ProductoMapper {

	@NonNull
	protected final SqlSession sqlSession;

	@Override
	public void crearTablaProducto() {
		this.sqlSession.getMapper(ProductoMapper.class).crearTablaProducto();
	}

//	@Override
	@Transactional
	public void insertarProductosPrueba(int cantidad) {
		for(int i=1;i<=cantidad;i++) {
			Producto p = new Producto(null,i*1000.0,"Producto"+i);
			this.insertarProducto(p);
		}
	}

	@Override
	public List<Producto> obtenerProducto(Double precioMinimo, String nombre) {
		return this.sqlSession.getMapper(ProductoMapper.class).obtenerProducto(precioMinimo, nombre);
	}

	@Override
	public void insertarProducto(Producto p) {
		this.sqlSession.getMapper(ProductoMapper.class).insertarProducto(p);
		
	}
	
	@PostConstruct
	@Transactional
	protected void init() {
		crearSecuenciaProducto();
		crearTablaProducto();
		insertarProductosPrueba(100);
		
	}

	@Override
	public void crearSecuenciaProducto() {
		this.sqlSession.getMapper(ProductoMapper.class).crearSecuenciaProducto();
	}

}
