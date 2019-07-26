package com.ies.curso.spring.tema10.ejemplo02.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ies.curso.spring.tema10.ejemplo02.exceptions.JwtAuthException;
import com.ies.curso.spring.tema10.ejemplo02.jwt.JwtTokenProvider;
import com.ies.curso.spring.tema10.ejemplo02.service.UserTokenService;

@Service
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired
	protected JwtTokenProvider jwtTokenProvider;

	@Autowired
	protected UserDetailsService userDetailsService;

	@Autowired
	protected AuthenticationManager authenticationManager;

	@Override
	public String signin(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return jwtTokenProvider.createToken(username,
					userDetailsService.loadUserByUsername(username).getAuthorities());
		} catch (AuthenticationException e) {
			throw new JwtAuthException("Usuario/Password inválidos", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public String refresh(String username) {
		return jwtTokenProvider.createToken(username, userDetailsService.loadUserByUsername(username).getAuthorities());
	}

	@Override
	public UserDetails obtenerUsuario(HttpServletRequest req) {
		 return userDetailsService.loadUserByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
	}

	

}
