package com.luis.backend.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColaboradorDTO {

	private Integer id_colaborador;
	private String nome;
	private String descricao;
	private Byte foto;
	private String endereco;
	private String departamento;
	private String cargo;
	private String latitude;
	private String longitude;


	

}
