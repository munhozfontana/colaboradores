package com.luis.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luis.backend.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("Select c from Usuario c where c.login LIKE %?1% and senha LIKE %?2%")
	Usuario findUser(String nome, String senha);

}
