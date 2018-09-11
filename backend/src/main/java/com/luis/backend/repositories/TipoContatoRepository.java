package com.luis.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.TipoContato;

@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer> {

}
