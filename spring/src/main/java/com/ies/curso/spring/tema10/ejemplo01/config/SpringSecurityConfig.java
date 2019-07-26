package com.ies.curso.spring.tema10.ejemplo01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
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

import com.ies.curso.spring.tema10.ejemplo01.security.RestAccessDeniedHandler;
import com.ies.curso.spring.tema10.ejemplo01.security.RestAuthenticationEntryPoint;
import com.ies.curso.spring.tema10.ejemplo01.security.RestAwareAuthenticationSuccessHandler;
import com.ies.curso.spring.tema10.ejemplo02.jwt.JwtTokenFilterConfigurer;
import com.ies.curso.spring.tema10.ejemplo02.jwt.JwtTokenProvider;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableWebSecurity
public class SpringSecurityConfig implements WebMvcConfigurer {

	/**
	 * EJEMPLO 01
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * EJEMPLO 01
	 * 
	 * @throws Exception
	 */
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}

	/**
	 * Ejemplo 01 Protegemos una api REST Creamos una clase estática para manejar
	 * los procedimientos específicos con un @Order 1 para que primero evalúe este
	 * método de autenticación.
	 * 
	 * En caso de no aplicar, ejecutará el procedimiento default
	 */
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		protected RestAccessDeniedHandler accessDeniedHandler;

		@Autowired
		protected RestAuthenticationEntryPoint restAuthenticationEntryPoint;

		@Autowired
		protected RestAwareAuthenticationSuccessHandler successHandler;

		protected SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

		protected void configure(HttpSecurity http) throws Exception {
			log.info("Configurando seguridad REST");
			http.antMatcher("/secure-api/**") // Restringimos la configuración a este prefijo
					.csrf().disable() /*
										 * Deshabilitamos el filtro CSRF, como maneja tokens para llevar un registro de
										 * invocaciones, puede ocasionar problema con REST
										 */
					.exceptionHandling() // Permite manejar errores de autenticación
					.accessDeniedHandler(accessDeniedHandler) // Maneja el control de acceso con base en roles
					.authenticationEntryPoint(restAuthenticationEntryPoint) /*
																			 * Redirige al punto de autenticación en
																			 * caso de que se requiera
																			 */
					.and().authorizeRequests() // Evaluará las siguientes rutas para definir si permite el acceso
					.antMatchers("/secure-api/user/**").authenticated() /*
																		 * Con estar autenticados podemos ingresar a
																		 * esas rutas
																		 */
					.antMatchers("/secure-api/admin/**").hasRole("ADMIN") /*
																			 * Solo permite el acceso a esa ruta si se
																			 * cuenta con el rol ADMIN
																			 */
					.and().formLogin() // Se define un login de tipo "formulario" en caso de requerirse
					.loginPage("/secure-api/login").permitAll().successHandler(successHandler) // Si es exitoso el login
																								// invocamos el
																								// SuccessHandler
					.failureHandler(failureHandler) // si falla invocamos el failureHandler
					.and().logout() // Interceptamos las funciones de logout de ser necesario
			;
		}
	}

	/**
	 * EJEMPLO 01 Procedimiento default
	 *
	 */
	@Configuration
	@Order(3)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			log.info("Configurando seguridad normal");
			http.authorizeRequests()
//                .antMatchers("/login").permitAll() // Permite las solicitudes de login
					.anyRequest().authenticated() // Cualquier solicitud debe ir autenticada
					.and().formLogin().loginPage("/login") // La pagina de login estará en la ruta
					.permitAll() // Naturalmente el login no debe estar restringido
					.and().logout().permitAll() // El logout tampoco estará restringido
					.logoutRequestMatcher(
							new AntPathRequestMatcher("/logout")); /*
																	 * Forzamos a que acepte un GET para invocar logout
																	 */

		}
	}

	/**
	 * EJEMPLO 01
	 * 
	 * Si alguien invoca la URL /loginnormal pintamos la vista login (.html)
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	/**
	 * EJEMPLO 02
	 * 
	 * Procesamiento de autenticación con tokens JWT
	 * 
	 */
	@Configuration
	@Order(2)
	public static class JwtWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		private JwtTokenProvider jwtTokenProvider;

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.antMatcher("/jwt/**").csrf().disable();
			http.sessionManagement() //Prohibimos la creación de sesiones
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.authorizeRequests()//
					.antMatchers("/jwt/signin").permitAll()//
					.antMatchers("/jwt/signup").permitAll()//
					.anyRequest().authenticated();

			http.exceptionHandling().accessDeniedPage("/login");

			// Agregamos el filtro para procesar JWT
			http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
	}
}
