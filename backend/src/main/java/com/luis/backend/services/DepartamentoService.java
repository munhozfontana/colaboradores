package com.luis.backend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Departamento;
import com.luis.backend.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepo;

	@Transactional
	public List<Departamento> find() {
		return departamentoRepo.findAll();
	}

}
