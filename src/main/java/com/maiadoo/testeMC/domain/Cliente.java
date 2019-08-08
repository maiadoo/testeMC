package com.maiadoo.testeMC.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maiadoo.testeMC.domain.enuns.TipoCliente;

@Entity
public class Cliente implements Serializable{ //A classe pode converter os atributos para dados 
											//para que eles possam ser gravados em arquivos, trafegados em rede, etc.  	
	private static final long serialVersionUID = 1L; //Controle de versao, exigencia do serializable
	
	//Atributos basicos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gera chave primaria no BD de teste H2	
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo; //Internamente ele será reconhecido como dado Integer mas externamente como um tipo enumerado TipoCliente
	
	@JsonManagedReference //Tudo certo em serializar os endereços, parar referencia ciclica
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>(); //Um cliente pode ter mais de um endereço
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE") //Tabela auxiliar com os telefones
	private Set<String> telefones = new HashSet<String>(); //Um cliente pode ter mais de um telefone que não repetem(usando Set)
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente() {
		
	}

	//Não coloca coleções
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod(); //Para ser reconhecido como TipoCliente
	}//

	//Gets e sets
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo); //Para ser reconhecido como TipoCliente; chama o tipo enumerado e a função feita para essa conversão
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod(); //Para ser reconhecido como TipoCliente
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}//
	
		
	
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
