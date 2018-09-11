package com.luis.backend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.luis.backend.domain.Colaborador;
import com.luis.backend.domain.Contato;
import com.luis.backend.domain.TipoContato;
import com.luis.backend.domain.Usuario;
import com.luis.backend.dto.ContatoNewDTO;
import com.luis.backend.repositories.ContatoRepository;
import com.luis.backend.repositories.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Transactional
	public Usuario login(Usuario obj) {
		return usuarioRepo.findUser(obj.getLogin(),obj.getSenha());
	}

}
