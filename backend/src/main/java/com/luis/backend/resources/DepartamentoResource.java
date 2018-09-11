package com.luis.backend.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luis.backend.domain.Departamento;
import com.luis.backend.dto.DepartamentoDTO;
import com.luis.backend.services.DepartamentoService;


@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoResource {

	@Autowired
	private DepartamentoService service;

	// Método para listar todas os departamentos
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> find() {
		List<Departamento> list = service.find();
		List<DepartamentoDTO> lisDto = list.stream().map(obj ->  new DepartamentoDTO(obj.getId(), obj.getNome())
				).collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}



}
