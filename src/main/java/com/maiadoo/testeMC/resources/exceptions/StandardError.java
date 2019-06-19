package com.maiadoo.testeMC.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{ // Retornar JSON organizado; erro padrao
	private static final long serialVersionUID = 1L;

		
	private Integer status; //Em HTML o status do erro
	private String msg; // Mensagem do erro
	private Long timeStamp; //Momento do erro
	
	
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
