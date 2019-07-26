package com.ies.curso.spring.tema10.ejemplo02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ies.curso.spring.tema10.ejemplo02.service.UserTokenService;

@RestController
@RequestMapping("/jwt")
public class JwtController {

	@Autowired
	protected UserTokenService userTokenService;

	@PostMapping("/signin")
	public String login(@RequestParam String username,
			@RequestParam String password) {
		return userTokenService.signin(username, password);
	}
	
	@GetMapping("/refresh")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
	public String refresh(HttpServletRequest req) {
		return userTokenService.refresh(req.getRemoteUser());
	}

	@GetMapping("/saludar")
	public String saludar(HttpServletRequest req) {
		return "HOLA "+userTokenService.obtenerUsuario(req).getUsername()+", bienvenido por JWT";
	}
}
