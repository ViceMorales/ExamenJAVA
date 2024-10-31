package com.vicentemorales.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicentemorales.modelos.Habilidades;
import com.vicentemorales.modelos.Login;
import com.vicentemorales.modelos.Usuario;

import com.vicentemorales.repositorios.RepositorioUsuario;
import com.vicentemorales.servicios.ServicioUsuarios;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuario {

	@Autowired
	ServicioUsuarios servicio;
	RepositorioUsuario repositorio;
	Habilidades habilidades;
	/*ServicioHabilidades servicioHabilidades;*/
	
	
	public ControladorUsuario(ServicioUsuarios servicio, RepositorioUsuario repositorio) {
		this.servicio = servicio;
		this.repositorio = repositorio;
	}

	@GetMapping("/registro")
	public String registraUsuario(@ModelAttribute Usuario usuario,
								Model model){
		model.addAttribute("usuario", usuario);
		return "registro.jsp";
	}
	
	@PostMapping("/procesa/registro")
	public String procesarAgregarRegistro(@Valid @ModelAttribute("nuevoUsuario")Usuario nuevoUsuario,
											BindingResult validaciones,
											HttpSession sesion){
		validaciones = this.servicio.validarRegistro(validaciones, nuevoUsuario);
		if(validaciones.hasErrors()) {
				return "registro.jsp";
		}
		this.servicio.agregarUsuario(nuevoUsuario);
		sesion.setAttribute("id_usuario", nuevoUsuario.getId());
		sesion.setAttribute("nombre_usuario", nuevoUsuario.getNombre() + " " + nuevoUsuario.getApellido());
		return "redirect:/inicio";
		}
	
	@GetMapping("/login")
	public String ingresaUsuario(@ModelAttribute Login login,
								@ModelAttribute Usuario usuario,
								Model model){
		model.addAttribute("login", login);
		return "login.jsp";
	}
	
	
	@PostMapping("/procesa/login")
	public String procesaLogin(@Valid @ModelAttribute Login login,
										BindingResult validaciones,
										HttpSession sesion) {
		validaciones = this.servicio.validarLogin(validaciones, login, sesion);
		
		if(validaciones.hasErrors()) {
			
			return "login.jsp";
		}
		
		return "redirect:/inicio";
	}
	
	@GetMapping("/elimiar/sesion")
	public String eliminarSesion(HttpSession sesion) {
		sesion.invalidate();
		return"redirect:/login";
		
	}
	@GetMapping("/usuario/editar/{id}")
	public String formularioEditarUsuario(@ModelAttribute("usuario") Usuario usuario,
											@PathVariable Long id,
											Model model,
											HttpSession sesion){
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
		usuario = this.servicio.obtenerUsuarioPorId(id);
		usuario.setContrasena(null);
		model.addAttribute("usuario", usuario);
		return "editarUsuario.jsp";
		
	    }
	
 	@PutMapping("/usuario/procesa/editar/{id}")
   	public String procesarEditarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
   										BindingResult validaciones,
                                         @PathVariable("id") Long id,
                                   
                                         HttpSession sesion) {
 	
 		if(validaciones.hasErrors()) {
   			return "editarUsuario.jsp";
   		}
   		usuario.setId(id);
		this.servicio.actualizarUsuario(usuario);
     	  	return "redirect:/inicio";
   	}
}
