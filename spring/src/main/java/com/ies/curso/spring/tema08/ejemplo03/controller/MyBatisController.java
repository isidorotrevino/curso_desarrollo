package com.ies.curso.spring.tema08.ejemplo03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ies.curso.spring.tema08.ejemplo03.dto.Producto;
import com.ies.curso.spring.tema08.ejemplo03.persistence.impl.ProductoDaoImpl;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {

	@Autowired
	protected ProductoDaoImpl productoDao;
	
	@GetMapping(path="/",produces = "application/json")
	public List<Producto> consultarProductos(
			@RequestParam(name = "precio",required = true)Double precio,
			@RequestParam(name = "nombre",required = false)String nombre) {
		return productoDao.obtenerProducto(precio, nombre);
	}
	
}
