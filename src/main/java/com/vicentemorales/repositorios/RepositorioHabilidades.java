package com.vicentemorales.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicentemorales.modelos.Habilidades;

@Repository 
public interface RepositorioHabilidades extends CrudRepository<Habilidades, Long> {
	// CRUD
	// C - Create
	// R - Read
	// U - Update
	// D - Delete
	
	List<Habilidades>findAll();
	
	Optional<Habilidades> findById(Long id);
}
