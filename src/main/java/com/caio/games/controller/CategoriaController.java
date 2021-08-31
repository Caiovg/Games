package com.caio.games.controller;

import java.util.List;

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

import com.caio.games.model.Categoria;
import com.caio.games.services.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria(){
		List<Categoria> obj = service.findAllCategoria();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findByIDCategoria(@PathVariable Integer id){
		ResponseEntity<Categoria> obj = service.findByIDCategoria(id);
		return obj;
	}
	
	@GetMapping(value = "/description/{description}")
	public ResponseEntity<Categoria> findByDescricaoCategoria(@PathVariable String description){
		ResponseEntity<Categoria> obj = service.findByDescricaoCategoria(description);
		return obj;
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria category){
		ResponseEntity<Categoria> obj = service.postCategoria(category);
		return obj;
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria category){
		ResponseEntity<Categoria> obj = service.putCategoria(category);
		return obj;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Integer id) {
		service.deleteCategoria(id);
	}
}
