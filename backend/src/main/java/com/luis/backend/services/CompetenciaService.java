package com.luis.backend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Colaborador;
import com.luis.backend.domain.Competencia;
import com.luis.backend.dto.CompetenciaNewDTO;
import com.luis.backend.repositories.CompetenciaRepository;

@Service
public class CompetenciaService {

	@Autowired
	private CompetenciaRepository competenciaRep;

	@Transactional
	public List<Competencia> findAll() {
		return competenciaRep.findAll();
	}

	@Transactional
	public List<Competencia> find(Integer id) {
		return competenciaRep.findCompetenciaById(id);
	}

	@Transactional
	public Competencia insert(Competencia obj) {
		return competenciaRep.save(obj);
	}

	public Competencia FromDTO(CompetenciaNewDTO objDto) {
		Colaborador col = new Colaborador(objDto.getColaborador(), null, null, null, null, null, null, null);
		Competencia com = new Competencia(null, objDto.getNome(), col);
		System.out.println(com.getNome());
		System.out.println(objDto.getColaborador());
		System.out.println(objDto.getId());
		return com;
	}


}
