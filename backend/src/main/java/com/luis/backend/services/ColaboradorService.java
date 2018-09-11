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

	private Endereco endereco;

	@Autowired
	private ColaboradorRepository colaboradorRepo;

	@Autowired
	private EnderecoRepository enderecoRepo;

	public List<Colaborador> findAll() {
		return colaboradorRepo.findAll();
	}

	public Colaborador find(Integer id) {
		Optional<Colaborador> obj = colaboradorRepo.findById(id);
		return obj.orElse(null);
	}

	@Transactional
	public Colaborador insert(Colaborador obj) {
		this.endereco = enderecoRepo.save(obj.getEndereco());
		obj.getEndereco().setId(this.endereco.getId());
		return obj = colaboradorRepo.save(obj);
	}

	@Transactional
	public Colaborador update(Colaborador obj) {
		Colaborador newObj = find(obj.getId());
		updateData(newObj, obj);
		return colaboradorRepo.save(newObj);
	}
	
	@Transactional
	public void delete(Integer id) {
		 colaboradorRepo.deleteById(id);
	}

	public Colaborador fromDTO(ColaboradorNewDTO objDto) {
		Endereco end = new Endereco(null, objDto.getEndereco(), objDto.getLatitude(), objDto.getLongitude(), null);
		Usuario usu = new Usuario(objDto.getUsuario_id(), null, null, null);
		Departamento dep = new Departamento(objDto.getDepartamento_id(), null, null);
		Cargo car = new Cargo(objDto.getCargo_id(), null, null);

		Colaborador col = new Colaborador(null, objDto.getNome(), objDto.getDescricao(), objDto.getFoto(), end, usu, dep, car);
		return col;
	}

	public Page<Colaborador> findPage(Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		return colaboradorRepo.findAll(pageRequest);
	}

	private void updateData(Colaborador newObj, Colaborador obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setFoto(obj.getFoto());
		newObj.setNome(obj.getNome());
		newObj.getEndereco().setLatitude((obj.getEndereco().getLatitude()));
		newObj.getEndereco().setLongitude((obj.getEndereco().getLongitude()));
//		newObj.set
//		newObj.set
		
	}
}
