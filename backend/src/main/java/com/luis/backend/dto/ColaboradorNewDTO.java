package com.luis.backend.dto;

import java.io.Serializable;

public class ColaboradorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;
	private Byte foto;
	private String endereco;
	private String latitude;
	private String longitude;

	private Integer endereco_id;
	private Integer usuario_id;
	private Integer departamento_id;
	private Integer cargo_id;

	public ColaboradorNewDTO() {

	}

	public ColaboradorNewDTO(String nome, String descricao, Byte foto, String endereco, String latitude,
			String longitude, Integer endereco_id, Integer usuario_id, Integer departamento_id, Integer cargo_id) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.foto = foto;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.endereco_id = endereco_id;
		this.usuario_id = usuario_id;
		this.departamento_id = departamento_id;
		this.cargo_id = cargo_id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Integer endereco_id) {
		this.endereco_id = endereco_id;
	}

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Integer getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(Integer departamento_id) {
		this.departamento_id = departamento_id;
	}

	public Integer getCargo_id() {
		return cargo_id;
	}

	public void setCargo_id(Integer cargo_id) {
		this.cargo_id = cargo_id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
