package com.maiadoo.testeMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.maiadoo.testeMC.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	//Operacoes de acesso a dados referentes ao objeto Categoria, mapeado como a tabela Categoria no BD
	
	
}
