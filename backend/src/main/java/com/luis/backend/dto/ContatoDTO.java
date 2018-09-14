package com.luis.backend.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String contato;


}
