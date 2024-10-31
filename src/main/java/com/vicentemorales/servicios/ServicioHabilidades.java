package com.vicentemorales.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicentemorales.modelos.Habilidades;

import com.vicentemorales.repositorios.RepositorioHabilidades;

@Service
public class ServicioHabilidades {
	@Autowired
	RepositorioHabilidades repositorioHabilidades ;
	
	public List<Habilidades> obtenerTodasLasHabilidades(){
		return repositorioHabilidades.findAll();
	}
	public Habilidades obtenerUno(Long id) {
		return this.repositorioHabilidades.findById(id).orElse(null);
	}
	public Habilidades agregarHabilidades(Habilidades habilidadesNuevo) {
   		return this.repositorioHabilidades.save(habilidadesNuevo);
	}
	public Habilidades actualizarVideojuegos(Habilidades habilidadesActualizar) {
   		return this.repositorioHabilidades.save(habilidadesActualizar);
	}
 	public void eliminarHabilidades(Long idHabilidades) {
   		this.repositorioHabilidades.deleteById(idHabilidades);
	}
}
