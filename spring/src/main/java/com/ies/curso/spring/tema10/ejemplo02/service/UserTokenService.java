package com.ies.curso.spring.tema10.ejemplo02.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserTokenService {

	public String signin(String username, String password);
	
	public String refresh(String username);

	public UserDetails obtenerUsuario(HttpServletRequest req);
}
