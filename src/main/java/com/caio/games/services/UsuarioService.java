package com.caio.games.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.caio.games.services.exception.DataIntegratyViolationException;
import com.caio.games.services.exception.ObjectNotFoundException;
import com.caio.games.model.Usuario;
import com.caio.games.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	/*Busca todos aos usuarios*/
	public List<Usuario> findAll(){
		List<Usuario> list = repository.findAll();
		if(list.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhum usuario");
		}
		return list;
	}
	
	/*
	 * Busca pelo ID
	 */
	public ResponseEntity<Usuario> findById(Integer id) {
		return repository.findById((int) id).map(
				resp -> ResponseEntity.ok(resp)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " não existe, Tipo: " + Usuario.class.getName()));
	}
	
	/*
	 * Cria um novo usuario
	 */
	public Optional<Object> createUser(Usuario usuario) {
		return Optional.ofNullable(repository.findByEmail(usuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty().orElseThrow(() -> new ObjectNotFoundException("Email ja cadastrado"));
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			return Optional.ofNullable(repository.save(usuario));
		}));
	}
	
}