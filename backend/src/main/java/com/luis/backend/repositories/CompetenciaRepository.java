package com.luis.backend.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Competencia;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {


@Query("select p from Competencia p where colaborador_id = :id")
public List<Competencia> findCompetenciaById(@Param("id") Integer id);
										



}
