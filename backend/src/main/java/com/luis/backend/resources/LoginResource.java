package com.luis.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luis.backend.domain.Usuario;
import com.luis.backend.services.LoginService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/login")
public class LoginResource {
	
	@Autowired
	private LoginService service;
	private Usuario res;

	// Método para fazer login no sistema
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> find(@RequestBody Usuario obj) {
		res = service.login(obj);
		if(res != null) {
			return ResponseEntity.status(200).body(res);
		}
		return ResponseEntity.notFound().build();
	}
}
