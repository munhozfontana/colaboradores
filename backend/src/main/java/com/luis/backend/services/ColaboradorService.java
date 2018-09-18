package com.luis.backend.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Cargo;
import com.luis.backend.domain.Colaborador;
import com.luis.backend.domain.Departamento;
import com.luis.backend.domain.Endereco;
import com.luis.backend.domain.Usuario;
import com.luis.backend.dto.ColaboradorNewDTO;
import com.luis.backend.repositories.ColaboradorRepository;
import com.luis.backend.repositories.EnderecoRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepo;

	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private CompetenciaService competenciaService;
	
	@Autowired
	private ContatoService contatoService;

	public List<Colaborador> findAll() {
		return colaboradorRepo.findAll();
	}

	public Colaborador find(Integer id) {
		Optional<Colaborador> obj = colaboradorRepo.findById(id);
		Endereco end = enderecoRepo.findEndereco(obj.get().getId());
		obj.get().setEndereco(end);
		return obj.orElse(null);
	}

	@Transactional
	public Colaborador insert(Colaborador obj) {
		Colaborador col = colaboradorRepo.save(obj);
		col.getEndereco().setColaborador(col);
		enderecoRepo.save(col.getEndereco());
		return col;

	}

	@Transactional
	public Colaborador update(Colaborador obj, Integer id) {
		Colaborador newObj = find(id);
		updateData(newObj, obj);
		Colaborador col = colaboradorRepo.save(newObj);
		enderecoRepo.saveEndereco(obj.getEndereco().getEndereco(), obj.getEndereco().getLatitude(),
				obj.getEndereco().getLongitude(), id);
		enderecoRepo.deleteRestEnd();
		return col;
	}

	@Transactional
	public void delete(Integer id) {
		competenciaService.deleteCompetenciasById(id);
		contatoService.deleteContatosById(id);
		Optional<Colaborador> col = colaboradorRepo.findById(id);
		colaboradorRepo.delete(col.get());
	}

	public Colaborador fromDTO(ColaboradorNewDTO objDto) {
		Endereco end = new Endereco(null, objDto.getEndereco(), objDto.getLatitude(), objDto.getLongitude(), null);
		Usuario usu = new Usuario(objDto.getUsuario_id(), null, null);
		Departamento dep = new Departamento(objDto.getDepartamento_id(), null);
		Cargo car = new Cargo(objDto.getCargo_id(), null);

		Colaborador col = new Colaborador(null, objDto.getNome(), objDto.getBibliografia(), objDto.getFoto(), usu, dep,
				car, end);
		return col;
	}

	public Page<Colaborador> findPage(Integer page, Integer linesPerPage, String nome) {
			PageRequest pageRequest = PageRequest.of(page, linesPerPage);
			
			
			 List<Colaborador> colaboradores = colaboradorRepo.findAll();
			 
			 
//			 List<Colaborador> colFilter = colaboradorRepo.search(nome, pageRequest);
		return	colaboradorRepo.search(nome, pageRequest);
		
	}

	private void updateData(Colaborador newObj, Colaborador obj) {
		newObj.setBibliografia(obj.getBibliografia());
		newObj.setFoto(obj.getFoto());
		newObj.setNome(obj.getNome());
		newObj.setEndereco(obj.getEndereco());

	}
}
