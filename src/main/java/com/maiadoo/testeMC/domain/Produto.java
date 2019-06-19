package com.maiadoo.testeMC.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produto implements Serializable{ //A classe pode converter os atributos para dados 
							//para que eles possam ser gravados em arquivos, trafegados em rede, etc.  	
	private static final long serialVersionUID = 1L; //Controle de versao, exigencia do serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gera chave primaria no BD de teste H2
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonBackReference //Do outro lado já foram buscadas as referecias
	@ManyToMany //Relacionamento muitos para muitos
	@JoinTable(name = "PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	) //Definicao de tabela relacional; nome da tabela, chave estrangeira de produto e categoria	
	private List<Categoria> categorias = new ArrayList<>(); // Um produto pode ter uma ou mais categorias, instancia porque e uma colecao
	
	public Produto() { // Nao adicionar colecoes como paramentro no construtor já que foi instanciada acima		
	}

	//Metodo construtor
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}//
	
	
	
}
