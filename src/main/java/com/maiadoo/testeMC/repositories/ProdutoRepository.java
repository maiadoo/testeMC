package com.maiadoo.testeMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.maiadoo.testeMC.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	//Operacoes de acesso a dados referentes ao objeto Categoria, mapeado como a tabela Categoria no BD
	
	
}
