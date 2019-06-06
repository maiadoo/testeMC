package com.maiadoo.testeMC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiadoo.testeMC.domain.Categoria;
import com.maiadoo.testeMC.repositories.CategoriaRepository;

@Service
public class CategoriaService { 
	//Declaracao de dependencia
	
	@Autowired //Automaticamente instancia pelo Spring por injecao de dependencia ou controle
	private CategoriaRepository repo; //O servico acessa do repositorio de acesso a dados
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id); //Busca categoria com o id e retorna como objeto
		return obj;
	}
	
}
