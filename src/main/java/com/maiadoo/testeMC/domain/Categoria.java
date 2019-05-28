package com.maiadoo.testeMC.domain;

import java.io.Serializable;

public class Categoria implements Serializable{ //A classe pode converter os atributos para dados 
										//para que eles possam ser gravados em arquivos, trafegados em rede, etc.  	
	private static final long serialVersionUID = 1L; //Controle de versao, exigencia do serializable
	
	//Atributos basicos
	private Integer id;
	private String nome;//
	
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
	}//

	//Comparar valores por conteudo e nao ponteiro de memoria, so ID
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
