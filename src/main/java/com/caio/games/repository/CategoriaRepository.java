package com.caio.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caio.games.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	@Query("SELECT obj FROM Categoria obj WHERE UPPER(obj.description) LIKE CONCAT('%',UPPER(:description),'%')")
	Categoria findByDescription(@Param("description") String description);

}
