package com.maiadoo.testeMC;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maiadoo.testeMC.domain.Categoria;
import com.maiadoo.testeMC.domain.Produto;
import com.maiadoo.testeMC.repositories.CategoriaRepository;
import com.maiadoo.testeMC.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteMcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Instanciar os objetos de Categoria
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//Instanciar produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3)); //Salvando em lista os produtos associados a cada categoria
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1)); //Salvando em lista as categorias de cada produto
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2)); 
		p3.getCategorias().addAll(Arrays.asList(cat1)); 
		
		categoriaRepository.save(Arrays.asList(cat1, cat2)); //Salvando em lista
		produtoRepository.save(Arrays.asList(p1, p2, p3)); //Salvando em lista
		
	}

}
