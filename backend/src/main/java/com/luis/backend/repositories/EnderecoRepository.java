package com.luis.backend.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	@Query("select p from Endereco p where colaborador_id = :id")
	public Endereco findEndereco(@Param("id") Integer id);


	@Transactional
	@Modifying
	@Query("UPDATE Endereco c SET c.endereco = :end, c.latitude = :lat, c.longitude = :lon WHERE colaborador_id = :id")
	public void saveEndereco(@Param("end") String end, @Param("lat") Float lat, @Param("lon") Float lon, @Param("id") Integer id);
	
	
	@Transactional
	@Modifying
	@Query("DELETE Endereco c WHERE colaborador_id is null")
	public void deleteRestEnd();

}
