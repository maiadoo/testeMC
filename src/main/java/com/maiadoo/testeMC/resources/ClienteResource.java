package com.maiadoo.testeMC.resources;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maiadoo.testeMC.domain.Cliente;
import com.maiadoo.testeMC.services.ClienteService;

@RestController // REST é um modelo de objeto HTTP
@RequestMapping(value = "/clientes")

public class ClienteResource {
	
	@Autowired
	private ClienteService service; //O REST acessa servico
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) //Testando REST
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//return "Rest funcionando!"; // O que deve aparecer ao digitar "localhost:8080/clientes" no Chrome
		
		Cliente obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj); // <?> - pode encontrar ou nao, objeto complexo, responta com HTTP envolvido
			
	}
	
}
