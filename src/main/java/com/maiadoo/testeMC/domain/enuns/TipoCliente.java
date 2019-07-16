package com.maiadoo.testeMC.domain.enuns;

public enum TipoCliente { //Tipo enumerado; guardandos os tipos de clientes no banco; Feito antes da classe cliente
	
	//Criando códigos e descrições para cada tipo enumerado 
	PESSOASFISICA (1, "Pessoa Física"), 
	PESSOAJURIDICA (2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente (int cod, String descricao) { //Método construtor de tipo enumerado é sempre private
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
	public static TipoCliente toEnum(Integer cod) { //Método estático roda mesmo sem objeto instanciado
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) { //Percorre todos os valores possíveis do tipo cliente 
			if(cod.equals(x.getCod())) { //Compara o código buscado ao código encontrado
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + cod); //Exceção caso o cod não seja encontrado
		
	}
	
}
