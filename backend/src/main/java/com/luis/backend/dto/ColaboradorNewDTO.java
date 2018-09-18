package com.luis.backend.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColaboradorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String bibliografia;
	private Byte foto;
	private String endereco;
	private Float latitude;
	private Float longitude;

	private Integer endereco_id;
	private Integer usuario_id;
	private Integer departamento_id;
	private Integer cargo_id;

	

}
