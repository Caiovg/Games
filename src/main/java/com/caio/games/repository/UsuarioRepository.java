package com.caio.games.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caio.games.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByUsuario(String usuario);

	Optional<Usuario> findByEmail(String email);
}
