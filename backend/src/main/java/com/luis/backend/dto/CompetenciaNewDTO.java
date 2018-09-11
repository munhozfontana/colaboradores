package com.luis.backend.dto;

import com.luis.backend.domain.Competencia;

public class CompetenciaNewDTO {

	private Integer id;
	private Integer colaborador;
	private String nome;

	public CompetenciaNewDTO() {

	}

	public CompetenciaNewDTO(Competencia obj) {

	}

	public CompetenciaNewDTO(Integer id, String nome, Integer colaborador) {
		super();
		this.id = id;
		this.nome = nome;
		this.colaborador = colaborador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getColaborador() {
		return colaborador;
	}

	public void setColaborador(Integer colaborador) {
		this.colaborador = colaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
