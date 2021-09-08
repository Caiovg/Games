package com.caio.games.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.games.model.Produto;
import com.caio.games.services.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> findAllProduto(){
		List<Produto> obj = service.findAllProduto();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findByIDProduto(@PathVariable Integer id){
		ResponseEntity<Produto> obj = service.findByIDProduto(id);
		return obj;
	}
	
	@GetMapping(value = "/title/{title}")
	public ResponseEntity<List<Produto>> findByDescricaoTitulo(@PathVariable String title){
		ResponseEntity<List<Produto>> obj = service.findByDescricaoTitulo(title);
		return obj;
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto product){
		ResponseEntity<Produto> obj = service.postProduto(product);
		return obj;
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto product){
		ResponseEntity<Produto> obj = service.putProduto(product);
		return obj;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Integer id) {
		service.deleteProduto(id);
	}
}
