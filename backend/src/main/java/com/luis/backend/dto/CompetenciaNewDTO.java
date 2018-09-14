package com.luis.backend.dto;

import com.luis.backend.domain.Competencia;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompetenciaNewDTO {

	private Integer id;
	private Integer colaborador;
	private String nome;



}
