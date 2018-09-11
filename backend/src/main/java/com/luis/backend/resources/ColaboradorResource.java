package com.luis.backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luis.backend.domain.Colaborador;
import com.luis.backend.dto.ColaboradorDTO;
import com.luis.backend.dto.ColaboradorNewDTO;
import com.luis.backend.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService service;

	// Método para buscar o Colaborador atravez de seu ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Colaborador obj = service.find(id);
		ColaboradorDTO objDto = new ColaboradorDTO(obj.getId(), obj.getNome(), obj.getDescricao(), obj.getFoto(),
				obj.getEndereco().getEndereco(), obj.getDepartamento().getNome(), obj.getCargo().getNome(),
				obj.getEndereco().getLatitude(), obj.getEndereco().getLongitude());
		return ResponseEntity.ok().body(objDto);
	}

	// Método para listar todos os colaboradores
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ColaboradorDTO>> findAll() {
		List<Colaborador> list = service.findAll();
		List<ColaboradorDTO> lisDto = list.stream()
				.map(obj -> new ColaboradorDTO(obj.getId(), obj.getNome(), obj.getDescricao(), obj.getFoto(),
						obj.getEndereco().getEndereco(), obj.getDepartamento().getNome(), obj.getCargo().getNome(),
						obj.getEndereco().getLatitude(), obj.getEndereco().getLongitude()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}

	// Método para cadastrar o colaborador
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ColaboradorNewDTO objDto) {
		Colaborador obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Método para remover o colaborador
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Colaborador> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Método para editar o colaborador
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ColaboradorNewDTO objDto, @PathVariable Integer id) {
		Colaborador obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// Método para paginação da lista de colaboradores
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ColaboradorDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage) {
		Page<Colaborador> list = service.findPage(page, linesPerPage);
		Page<ColaboradorDTO> lisDto = list.map(obj -> new ColaboradorDTO(obj.getId(), obj.getNome(), obj.getDescricao(),
				obj.getFoto(), obj.getEndereco().getEndereco(), obj.getDepartamento().getNome(),
				obj.getCargo().getNome(), obj.getEndereco().getLatitude(), obj.getEndereco().getLongitude()));
		return ResponseEntity.ok().body(lisDto);
	}

}
