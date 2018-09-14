package com.luis.backend.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContatoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String contato;
	private Integer colaborador;
	private Integer tipoContato;

}
