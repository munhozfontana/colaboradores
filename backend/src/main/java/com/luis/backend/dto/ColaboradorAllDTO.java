package com.luis.backend.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColaboradorAllDTO {

	private Integer id_colaborador;
	private String nome;
	private Byte foto;
	private String departamento;
	private String cargo;


	

}
