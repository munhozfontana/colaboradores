package com.luis.backend.dto;

import java.io.Serializable;

public class ContatoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String contato;

	private Integer colaborador;

	private Integer tipoContato;

	public ContatoNewDTO() {
	}

	public Integer getColaborador() {
		return colaborador;
	}

	public void setColaborador(Integer colaborador) {
		this.colaborador = colaborador;
	}

	public Integer getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
