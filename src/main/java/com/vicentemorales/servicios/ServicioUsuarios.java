package com.vicentemorales.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.vicentemorales.modelos.Habilidades;
import com.vicentemorales.modelos.Login;
import com.vicentemorales.modelos.Usuario;

import com.vicentemorales.repositorios.RepositorioUsuario;

import jakarta.servlet.http.HttpSession;


@Service
public class ServicioUsuarios {

	@Autowired
	private final RepositorioUsuario repositorioUsuario;
	
	public ServicioUsuarios(RepositorioUsuario repositorioUsuario) {
		super();
		this.repositorioUsuario = repositorioUsuario;
	}

	public List<Usuario> obtenerTodosLosUsuarios(){
		return repositorioUsuario.findAll();
	}
	
	public Usuario obtenerUsuarioPorId(Long idUsuario) {
		return this.repositorioUsuario.findById(idUsuario).orElse(null);
	}
	public Usuario obtenerPorNombreYContrasena(String correo, String contrasena) {
		return this.repositorioUsuario.findByCorreoAndContrasena(correo, contrasena);
	}
	
	public Usuario agregarUsuario(Usuario nuevoUsuario) {
		String contraseñaEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
		nuevoUsuario.setContrasena(contraseñaEncriptada);
		return this.repositorioUsuario.save(nuevoUsuario);
	}
	public Usuario actualizarUsuario(Usuario usuarioActualizar) {
		if (usuarioActualizar.getContrasena() != null && !usuarioActualizar.getContrasena().isEmpty()) {
	        String hashedPassword = BCrypt.hashpw(usuarioActualizar.getContrasena(), BCrypt.gensalt());
	        usuarioActualizar.setContrasena(hashedPassword);
	    }
		return this.repositorioUsuario.save(usuarioActualizar);
	}
	public Usuario obtenerPorNombre(Login login) {
		Usuario usuarioActual = this.repositorioUsuario.findByCorreo(login.getCorreo());
		
		if(usuarioActual != null) {
			if(BCrypt.checkpw(login.getContrasena(), usuarioActual.getContrasena())) {
				return usuarioActual;
			}
		}
		return null;
	}
	
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		if(! usuario.getContrasena().equals(usuario.getConfirmacionContrasena())) {
			validaciones.rejectValue("confirmacionContraseña", "contraseñaNoCoincide", "Las contraseñas deben de ser iguales.");
		}
			
		return validaciones;
	}
	public BindingResult validarLogin(BindingResult validaciones, 
			Login loginUsuario,
			HttpSession sesion) {
		Usuario usuarioActual = this.obtenerUnoParaLogin(loginUsuario.getCorreo());
		if(usuarioActual == null) {
		validaciones.rejectValue("contrasena", "contraseniaNoCoincide", "Credenciales incorrectas.");
		}
		else {
		String generatedHash = BCrypt.hashpw(loginUsuario.getContrasena(), BCrypt.gensalt());
		if(! BCrypt.checkpw(loginUsuario.getContrasena(), usuarioActual.getContrasena())) {
		validaciones.rejectValue("contrasena", "contraseniaNoCoincide", "Credenciales incorrectas.");
		}
		else {
		sesion.setAttribute("id_usuario", usuarioActual.getId());
		sesion.setAttribute("nombre_usuario", usuarioActual.getNombre() + " " + usuarioActual.getApellido());
		}
		}
		return validaciones;
		}
	
	public Usuario obtenerUnoParaLogin(String correo) {
		return this.repositorioUsuario.findByCorreo(correo);
	}
}
