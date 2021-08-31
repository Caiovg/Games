package com.caio.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caio.games.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Query("SELECT obj FROM Produto obj WHERE UPPER(obj.name) LIKE CONCAT('%',UPPER(:name),'%')")
	Produto findByName(@Param("name") String name);
}
