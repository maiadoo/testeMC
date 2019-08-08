package com.maiadoo.testeMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.maiadoo.testeMC.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	//Operacoes de acesso a dados referentes ao objeto Categoria, mapeado como a tabela Categoria no BD
	
	
}
