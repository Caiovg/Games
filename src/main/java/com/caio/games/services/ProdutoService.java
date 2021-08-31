package com.caio.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.games.model.Produto;
import com.caio.games.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAllProduto() {
		return repository.findAll();
	}

	public ResponseEntity<Produto> findByIDProduto(Integer id) {
		return repository.findById((int) id).map(
				resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Produto> findByDescricaoTitulo(String title) {
		return ResponseEntity.ok(repository.findByName(title));
	}

	public ResponseEntity<Produto> postProduto(Produto product) {
		return ResponseEntity.ok(repository.save(product));
	}

	public ResponseEntity<Produto> putProduto(Produto product) {
		return ResponseEntity.ok(repository.save(product));
	}
	
	public void deleteProduto(Integer id) {
		repository.deleteById(id);
	}

}
