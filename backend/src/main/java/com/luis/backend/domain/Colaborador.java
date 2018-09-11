package com.luis.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Byte foto;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	@MapsId
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	@JsonIgnore
	@OneToMany(mappedBy = "colaborador")
	private List<Competencia> competencias = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "colaborador")
	private List<Contato> contato = new ArrayList<>();

	Colaborador() {

	}

	public Colaborador(Integer id, String nome, String descricao, Byte foto, Endereco endereco, Usuario usuario,
			Departamento departamento, Cargo cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.foto = foto;
		this.endereco = endereco;
		this.usuario = usuario;
		this.departamento = departamento;
		this.cargo = cargo;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Competencia> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
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
		Colaborador other = (Colaborador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
