package com.luis.backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luis.backend.domain.Competencia;
import com.luis.backend.dto.CompetenciaDTO;
import com.luis.backend.dto.CompetenciaNewDTO;
import com.luis.backend.services.CompetenciaService;


@RestController
@RequestMapping(value = "/competencia")
public class CompetenciaResource {

	@Autowired
	private CompetenciaService service;
	
	// Método para listar todas as competencias
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CompetenciaDTO>> findAll() {
		List<Competencia> list = service.findAll();
		List<CompetenciaDTO> lisDto = list.stream().map(obj -> new CompetenciaDTO(obj.getColaborador().getId(), obj.getNome()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}

	// Método para listar todas as competencias de um colaborador
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CompetenciaDTO>> find(@PathVariable Integer id) {
		List<Competencia> list = service.find(id);
		List<CompetenciaDTO> lisDto = list.stream().map(obj -> new CompetenciaDTO(obj.getColaborador().getId(), obj.getNome()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}
	


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CompetenciaNewDTO objDto) {
		Competencia obj = service.FromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
