package com.maiadoo.testeMC;

//import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maiadoo.testeMC.domain.Categoria;
import com.maiadoo.testeMC.domain.Cidade;
import com.maiadoo.testeMC.domain.Cliente;
import com.maiadoo.testeMC.domain.Endereco;
import com.maiadoo.testeMC.domain.Estado;
import com.maiadoo.testeMC.domain.Produto;
import com.maiadoo.testeMC.domain.enuns.TipoCliente;
import com.maiadoo.testeMC.repositories.CategoriaRepository;
import com.maiadoo.testeMC.repositories.CidadeRepository;
import com.maiadoo.testeMC.repositories.ClienteRepository;
import com.maiadoo.testeMC.repositories.EnderecoRepository;
import com.maiadoo.testeMC.repositories.EstadoRepository;
import com.maiadoo.testeMC.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteMcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	
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
		
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Paraíba");
		
		Cidade c1 = new Cidade(null, "São Paulo", est1);
		Cidade c2 = new Cidade(null, "Campina Grande", est2);
		Cidade c3 = new Cidade(null, "João Pessoa", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1)); 
		est2.getCidades().addAll(Arrays.asList(c2, c3)); 
		
		estadoRepository.save(Arrays.asList(est1, est2)); //Estado precisa vir primeiro para ir relacionando as cidades
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOASFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("33394554", "33421551"));
		
		Endereco e1 = new Endereco(null, "Rua Silva", "320", "Ap. 3", "Jardim", "58400000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Juares", "32", "Sala 400", "Centro", "68400000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(Arrays.asList(cli1)); //Cliente salva primeiro pois é independente 
		enderecoRepository.save(Arrays.asList(e1, e2));
		
	}

}
