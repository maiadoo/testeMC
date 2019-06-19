package com.maiadoo.testeMC.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity 
public class Categoria implements Serializable{ //A classe pode converter os atributos para dados 
										//para que eles possam ser gravados em arquivos, trafegados em rede, etc.  	
	private static final long serialVersionUID = 1L; //Controle de versao, exigencia do serializable
	
	//Atributos basicos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gera chave primaria no BD de teste H2
	private Integer id;
	private String nome;//
	
	@ManyToMany(mappedBy = "categorias") //Mapeamento feito em categorias
	private List<Produto> produtos = new ArrayList<>(); //Uma categoria tem mais de um produto; instancia porque é uma colecao
	
	public Categoria() { // Nao adicionar colecoes como paramentro no construtor já que foi instanciada acima
		
	}
	
	//Metodo construtor
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}//

	//Metodos de acesso aos atributos, encapsulamentos 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}//

	//Comparar valores por conteudo e nao ponteiro de memoria, so ID, implementacao padrao
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}//

	
	
}
