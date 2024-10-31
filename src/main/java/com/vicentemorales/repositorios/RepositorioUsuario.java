package com.vicentemorales.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicentemorales.modelos.Habilidades;
import com.vicentemorales.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

	List<Usuario>findAll();
	Optional<Usuario> findById(Long id);
	
	Usuario findByCorreo(String correo);
	Usuario findByCorreoAndContrasena(String correo, String contrasena);
}
