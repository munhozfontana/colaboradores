package com.luis.backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luis.backend.domain.Contato;
import com.luis.backend.domain.TipoContato;
import com.luis.backend.dto.ContatoDTO;
import com.luis.backend.dto.ContatoNewDTO;
import com.luis.backend.services.ContatoService;


@RestController
@RequestMapping(value = "/contato")
public class ContatoResource {

	@Autowired
	private ContatoService service;

	// Método para listar todas os contatos de um colaborador
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ContatoDTO>> find(@PathVariable Integer id) {
		List<Contato> list = service.find(id);
		List<ContatoDTO> lisDto = list.stream().map(obj ->  new ContatoDTO(obj.getTipoContato().getId(), obj.getContato())
				).collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}
	
	// Método para listar todas os tipos de contatos
	@RequestMapping(value = "/tipo", method = RequestMethod.GET)
	public ResponseEntity<List<TipoContato>> find() {
		List<TipoContato> list = service.findAllTipos();
//		List<ContatoDTO> lisDto = list.stream().map(obj ->  new ContatoDTO(obj.getTipoContato().getId(), obj.getContato())
//				).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ContatoNewDTO objDto) {
		Contato obj = service.FromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
