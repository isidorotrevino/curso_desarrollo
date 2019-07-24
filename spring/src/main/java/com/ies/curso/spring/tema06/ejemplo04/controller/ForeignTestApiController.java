package com.ies.curso.spring.tema06.ejemplo04.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ies.curso.spring.tema06.ejemplo04.dto.GithubUser;

@Controller
@RequestMapping("/extapi")
public class ForeignTestApiController {

	@GetMapping(path="/github",produces = "application/json")
	@ResponseBody
	public GithubUser consultarUsuarioGithub(@RequestParam(name="nombre",required = true)String nombre) {
		RestTemplate restTemplate = new RestTemplate();
		GithubUser user = restTemplate.getForObject("https://api.github.com/users/"+nombre, GithubUser.class);
		return user;
	}
	
	@GetMapping(path="/noticias",produces = "application/json")
	@ResponseBody
	public Map<String,Object> consultarNoticias(){
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		Map<String,Object> resultado = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?"+
		"country=us&apiKey=37f264e2465f4388b0562dac2c4f52fc", Map.class);
		return resultado;
	}
	
	
}
