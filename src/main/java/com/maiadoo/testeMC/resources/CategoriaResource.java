package com.maiadoo.testeMC.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST é um modelo de objeto HTTP
@RequestMapping(value = "/categorias")

public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET) //Testando REST
	public String listar() {
		return "Rest funcionando!"; // O que deve aparecer ao digitar "localhost:8080/categorias" no Chrome
	}
	
}
