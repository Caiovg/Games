package com.caio.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caio.games.model.Usuario;
import com.caio.games.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll(){
		List<Usuario> list = repository.findAll();
		return list;
	}
}