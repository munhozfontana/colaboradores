package com.luis.backend.dto;

import java.io.Serializable;

public class ContatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String contato;

	ContatoDTO() {

	}
	
	public ContatoDTO(Integer id, String contato) {
		super();
		this.id = id;
		this.contato = contato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
