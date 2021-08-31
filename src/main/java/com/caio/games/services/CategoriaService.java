package com.caio.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.games.model.Categoria;
import com.caio.games.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAllCategoria() {
		return repository.findAll();
	}

	public ResponseEntity<Categoria> findByIDCategoria(Integer id) {
		return repository.findById((int) id).map(
				resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Categoria> findByDescricaoCategoria(String description) {
		return ResponseEntity.ok(repository.findByDescription(description));
	}

	
	public ResponseEntity<Categoria> postCategoria(Categoria category) {
		return ResponseEntity.ok(repository.save(category));
	}
	
	public ResponseEntity<Categoria> putCategoria(Categoria category) {
		return ResponseEntity.ok(repository.save(category));
	}
	
	public void deleteCategoria(Integer id) {
		repository.deleteById(id);
	}
}
