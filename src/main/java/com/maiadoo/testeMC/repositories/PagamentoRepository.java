package com.maiadoo.testeMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.maiadoo.testeMC.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	//Só precisa fazer repositório da superclasse
	
	
}
