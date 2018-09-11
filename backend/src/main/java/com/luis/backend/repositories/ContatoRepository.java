package com.luis.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

	@Query("select p from Contato p where colaborador_id = :id")
	public List<Contato> findContatoById(@Param("id") Integer id);
	
}
