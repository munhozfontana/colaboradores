package com.luis.backend.dto;

import com.luis.backend.domain.Colaborador;

public class ColaboradorDTO {

	private Integer id;
	private String nome;
	private String descricao;
	private Byte foto;
	private String endereco;
	private String departamento;
	private String cargo;
	private String latitude;
	private String longitude;

	public ColaboradorDTO() {

	}

	public ColaboradorDTO(Colaborador obj) {

	}


	public ColaboradorDTO(Integer id, String nome, String descricao, Byte foto, String endereco, String departamento,
			String cargo, String latitude, String longitude) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.foto = foto;
		this.endereco = endereco;
		this.departamento = departamento;
		this.cargo = cargo;
		this.latitude = latitude;
		this.longitude = longitude;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Byte getFoto() {
		return foto;
	}

	public void setFoto(Byte foto) {
		this.foto = foto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
