package com.maiadoo.testeMC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiadoo.testeMC.domain.Cliente;
import com.maiadoo.testeMC.repositories.ClienteRepository;
import com.maiadoo.testeMC.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService { 
	//Declaracao de dependencia
	
	@Autowired //Automaticamente instancia pelo Spring por injecao de dependencia ou controle
	private ClienteRepository repo; //O servico acessa do repositorio de acesso a dados
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id); //Busca categoria com o id e retorna como objeto
		if (obj == null) { //Se o objeto não existir ou não for encontrado lanca a excecao
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id +
					", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
}
