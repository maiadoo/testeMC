package com.maiadoo.testeMC.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.maiadoo.testeMC.domain.enuns.EstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //Mapeando herança e qual estratégia usar para mapear no banco (uma tabela p/ cada)
public abstract class Pagamento implements Serializable{ //A classe pode converter os atributos para dados 
										//para que eles possam ser gravados em arquivos, trafegados em rede, etc. 
										//É uma classe abstrata para que se possa instanciar diretamente uma de suas subclasses
	private static final long serialVersionUID = 1L; //Controle de versao, exigencia do serializable

	@Id
	private Integer id;
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId //Pagamento tem o mesmo ID do Pedido
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
