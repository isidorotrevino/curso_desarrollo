package com.ies.curso.spring.tema11.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;
	
@Configuration
@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("Configurando seguridad normal");
		http.authorizeRequests()
				.antMatchers("/user/**").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN","SUPER_ADMIN")
				.anyRequest().authenticated() // Cualquier solicitud debe ir autenticada
				.and().formLogin().loginPage("/login") // La pagina de login estará en la ruta
				.permitAll() // Naturalmente el login no debe estar restringido
				.and().logout().permitAll() // El logout tampoco estará restringido
				.logoutRequestMatcher(
						new AntPathRequestMatcher("/logout")); /*
																 * Forzamos a que acepte un GET para invocar logout
																 */
	}
	
	
	/**
	 * Configuración de autenticación (Ver tema 10)
	 * @return
	 */
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(5);
	}

	/**
	 * Configuración de autenticación (Ver tema 10)
	 * @throws Exception
	 */
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(encoder.encode("password")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user,admin);
	}


	

	/**
	 * Configuración de autenticación (Ver tema 10)
	 * 
	 * Si alguien invoca la URL /loginnormal pintamos la vista login (.html)
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		
	}

}
