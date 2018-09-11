package com.luis.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

//	@Query("select p from Cargo p where colaborador_id = :id")
//	public List<Cargo> findCargoById(@Param("id") Integer id);
	
}
