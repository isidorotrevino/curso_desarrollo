package com.ies.curso.spring.tema10.ejemplo02.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

	@NonNull
	protected JwtTokenProvider jwtTokenProvider;
	
	 @Override
	  public void configure(HttpSecurity http) throws Exception {
	    JwtTokenFilter jwtFilter = new JwtTokenFilter(jwtTokenProvider);
	    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	  }
}
