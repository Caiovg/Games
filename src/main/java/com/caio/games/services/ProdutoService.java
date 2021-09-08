package com.caio.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.games.model.Categoria;
import com.caio.games.model.Produto;
import com.caio.games.repository.ProdutoRepository;
import com.caio.games.services.exception.DataIntegratyViolationException;
import com.caio.games.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAllProduto() {
		List<Produto> list = repository.findAll();
		if(list.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhuma postagem");
		}
		return list;
	}

	public ResponseEntity<Produto> findByIDProduto(Integer id) {
		return repository.findById((int) id).map(
				resp -> ResponseEntity.ok(resp)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " não existe, Tipo: " + Categoria.class.getName()));
	}

	public ResponseEntity<List<Produto>> findByDescricaoTitulo(String title) {
		List<Produto> produto = repository.findByName(title);
		if(produto.isEmpty()) {
			throw new DataIntegratyViolationException("Não existe nenhuma postagem com esse titulo");
		}
		return ResponseEntity.ok(produto);
	}

	public ResponseEntity<Produto> postProduto(Produto product) {
		return ResponseEntity.ok(repository.save(product));
	}

	public ResponseEntity<Produto> putProduto(Produto product) {
		return ResponseEntity.ok(repository.save(product));
	}
	
	public void deleteProduto(Integer id) {
		ResponseEntity<Produto> obj = findByIDProduto(id);
		repository.deleteById(id);
	}

}
