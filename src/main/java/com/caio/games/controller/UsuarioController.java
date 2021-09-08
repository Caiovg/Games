package com.caio.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.games.model.Usuario;
import com.caio.games.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	/*
	 * Busca Todos
	 */
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
}