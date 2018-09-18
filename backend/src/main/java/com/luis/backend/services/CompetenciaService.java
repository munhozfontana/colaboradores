package com.luis.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Colaborador;
import com.luis.backend.domain.Competencia;
import com.luis.backend.dto.CompetenciaDTO;
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
		competenciaRep.delete(obj);
		return competenciaRep.save(obj);
	}
	
	@Transactional
	public void deleteCompetenciasById(Integer id) {
		System.out.println(id);
		competenciaRep.deleteCompetencias(id);
	}

	public Competencia FromDTO(CompetenciaNewDTO objDto) {
		Colaborador col = new Colaborador(objDto.getColaborador(), null, null, null, null, null, null, null);
		Competencia com = new Competencia(null, objDto.getNome(), col);
		return com;
	}


}
