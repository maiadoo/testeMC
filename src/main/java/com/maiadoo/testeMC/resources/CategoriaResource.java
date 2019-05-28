package com.maiadoo.testeMC.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maiadoo.testeMC.domain.Categoria;

@RestController // REST é um modelo de objeto HTTP
@RequestMapping(value = "/categorias")

public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET) //Testando REST
	public List<Categoria> listar() {
		
		//return "Rest funcionando!"; // O que deve aparecer ao digitar "localhost:8080/categorias" no Chrome
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista; //Retorna em formato JASON a lista de categorias
		
	}
	
}
