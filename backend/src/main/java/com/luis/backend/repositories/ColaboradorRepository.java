package com.luis.backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
	

}
