package com.luis.backend.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
	
	@Query("SELECT DISTINCT obj FROM Colaborador obj WHERE nome LIKE %:name%")
	Page<Colaborador> search(@Param ("name") String nome, Pageable pageable);
	
}
