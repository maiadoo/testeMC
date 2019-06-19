package com.maiadoo.testeMC.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) { //Aproveitando o tratamento de excecoes do proprio java
		super (msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) { 
		super (msg, cause); // Retorna a excecao e a causa 
	}
	
}
