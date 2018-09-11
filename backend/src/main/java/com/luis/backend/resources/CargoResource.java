package com.luis.backend.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luis.backend.domain.Cargo;
import com.luis.backend.dto.CargoDTO;
import com.luis.backend.services.CargoService;


@RestController
@RequestMapping(value = "/cargo")
public class CargoResource {

	@Autowired
	private CargoService service;

	// Método para listar todas os cargos de um colaborador
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CargoDTO>> find() {
		List<Cargo> list = service.find();
		List<CargoDTO> lisDto = list.stream().map(obj ->  new CargoDTO(obj.getId(), obj.getNome())
				).collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}



}
