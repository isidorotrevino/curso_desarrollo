package com.ies.curso.spring.tema08.ejemplo03.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ies.curso.spring.tema08.ejemplo03.dto.Producto;

@Mapper
public interface ProductoMapper {

	void crearTablaProducto();
	
	void crearSecuenciaProducto();
	
	void insertarProducto(@Param("p") Producto p);
	
	List<Producto> obtenerProducto(@Param("precioMinimo")Double precioMinimo,
			@Param("nombre") String nombre);
}
