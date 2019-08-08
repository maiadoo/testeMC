package com.maiadoo.testeMC.domain.enuns;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento (int cod, String descricao) { //Método construtor de tipo enumerado é sempre private
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//Só possuem gets pois os valores não vão mudar
	public int getCod() {
		return cod;
	}	
	
	public String getDescricao() {
		return descricao;
	}
	
	//Recebe um código e retorna um objeto tipo cliente convertido
	public static EstadoPagamento toEnum(Integer cod) { //Método estático roda mesmo sem objeto instanciado
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) { //Percorre todos os valores possíveis do tipo cliente 
			if(cod.equals(x.getCod())) { //Compara o código buscado ao código encontrado
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + cod); //Exceção caso o cod não seja encontrado
		
	}

}
