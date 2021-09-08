package com.caio.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.games.services.exception.DataIntegratyViolationException;
import com.caio.games.services.exception.ObjectNotFoundException;
import com.caio.games.model.Categoria;
import com.caio.games.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAllCategoria() {
		List<Categoria> list = repository.findAll(); 
		if(list.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhuma postagem");
		}
		return list; 
	}

	public ResponseEntity<Categoria> findByIDCategoria(Integer id) {
		return repository.findById((int) id).map(
				resp -> ResponseEntity.ok(resp)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " não existe, Tipo: " + Categoria.class.getName()));
	}

	public ResponseEntity<List<Categoria>> findByDescricaoCategoria(String description) {
		List<Categoria> categoria = repository.findByDescription(description);
		if(categoria.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhuma postagem com esse titulo");
		}
		return ResponseEntity.ok(categoria);
	}

	
	public ResponseEntity<Categoria> postCategoria(Categoria category) {
		return ResponseEntity.ok(repository.save(category));
	}
	
	public ResponseEntity<Categoria> putCategoria(Categoria category) {
		return ResponseEntity.ok(repository.save(category));
	}
	
	public void deleteCategoria(Integer id) {
		ResponseEntity<Categoria> obj = findByIDCategoria(id);
		repository.deleteById(id);
	}
}
