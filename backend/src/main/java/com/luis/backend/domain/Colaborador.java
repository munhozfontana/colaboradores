package com.luis.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter @Setter
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String bibliografia;
	private Byte foto;


	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "colaborador")
	@JsonIgnore
	private Endereco endereco;
	
	@OneToMany(mappedBy = "colaborador")
	@JsonIgnore
	private final List<Competencia> competencias = new ArrayList<>();

	@OneToMany(mappedBy = "colaborador")
	@JsonIgnore
	private final List<Contato> contato = new ArrayList<>();

}
