package com.luis.backend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String contato;

	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	@ManyToOne
	@JoinColumn(name = "tipo_contato_id")
	private TipoContato tipoContato;

	Contato() {

	}

	public Contato(Integer id, String contato, Colaborador colaborador, TipoContato tipoContato) {
		super();
		this.id = id;
		this.contato = contato;
		this.colaborador = colaborador;
		this.tipoContato = tipoContato;
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

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
