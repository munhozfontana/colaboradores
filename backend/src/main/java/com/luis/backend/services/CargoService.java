package com.luis.backend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Cargo;
import com.luis.backend.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepo;

	@Transactional
	public List<Cargo> find() {
		return cargoRepo.findAll();
	}

}
