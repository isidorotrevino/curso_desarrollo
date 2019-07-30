package com.ies.curso.spring.tema11.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ies.curso.spring.tema11.service.SeguridadService;

@Service
@PreAuthorize("isAuthenticated()")
public class SeguridadServiceImpl implements SeguridadService {

	@Autowired
	protected UserDetailsService userDetailsService;
	
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public String operacionUsuario() {
		return userDetailsService.loadUserByUsername("user").getUsername();
	}

	@Override
	@PostAuthorize("returnObject == authentication.principal.username")
	public String operacionAdministrador() {
		return userDetailsService.loadUserByUsername("admin").getUsername();
	}

}
