package com.luis.backend.dto;



import java.util.ArrayList;
import java.util.List;

import com.luis.backend.domain.Contato;
import com.luis.backend.domain.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColaboradorDTO {

	private Integer id_colaborador;
	private String nome;
	private String bibliografia;
	private Byte foto;
	private String departamento;
	private String cargo;
	private String endereco;
	private Float latitude;
	private Float longitude;
}
