package com.luis.backend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Colaborador;
import com.luis.backend.domain.Contato;
import com.luis.backend.domain.TipoContato;
import com.luis.backend.dto.ContatoNewDTO;
import com.luis.backend.repositories.ContatoRepository;
import com.luis.backend.repositories.TipoContatoRepository;

@Service
public class ContatoService {
	private Contato contato;

	@Autowired
	private ContatoRepository contatoRepo;
	
	@Autowired
	private TipoContatoRepository tipoContatoRepo;

	@Transactional
	public List<Contato> find(Integer id) {
		return contatoRepo.findContatoById(id);
	}
	
	@Transactional
	public List<TipoContato> findAllTipos() {
		return tipoContatoRepo.findAll();
	}
	
	

	@Transactional
	public Contato insert(Contato obj) {
		this.contato = contatoRepo.save(obj);
		obj.setId(this.contato.getId());
		return obj = contatoRepo.save(obj);
	}

	public Contato FromDTO(ContatoNewDTO objDto) {
		TipoContato tipo = new TipoContato(objDto.getTipoContato(), null);
		Colaborador col = new Colaborador(objDto.getColaborador(), null, null, null, null, null, null, null);
		Contato con = new Contato(null, objDto.getContato(), col, tipo);
		return con;
	}

}
