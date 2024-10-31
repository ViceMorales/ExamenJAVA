package com.vicentemorales.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.vicentemorales.modelos.Habilidades;
import com.vicentemorales.modelos.Usuario;
import com.vicentemorales.repositorios.RepositorioUsuario;
import com.vicentemorales.servicios.ServicioUsuarios;
import com.vicentemorales.servicios.ServicioHabilidades;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorHabilidades {
	@Autowired
	private final ServicioHabilidades servicioHabilidades;
	@Autowired
	private final ServicioUsuarios servicioUsuarios;
	
	public ControladorHabilidades(ServicioHabilidades servicioHabilidades, ServicioUsuarios servicioUsuarios) {
		super();
		this.servicioHabilidades = servicioHabilidades;
		this.servicioUsuarios = servicioUsuarios;
	}

	@GetMapping("/inicio")
	public String desplegarHabilidades( Model modelo,
										HttpSession sesion){
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
		List<Habilidades> habilidades = servicioHabilidades.obtenerTodasLasHabilidades();
		modelo.addAttribute("habilidades", habilidades);
		
		sesion.getAttribute("nombre_usuario");
		return "inicio.jsp";
	}
	
	@GetMapping("/agrega/habilidades")
	public String formularioAgregarHabilidades (@ModelAttribute Habilidades habilidades,
												HttpSession sesion) {
		if(sesion.getAttribute("id_usuario")== null) {
			return "redirect:/login";
		}
		return "agregarHabilidades.jsp";
	}
	
	@PostMapping("/procesar/habilidades/agregar")
	public String procesarAgregarHabilidades(@Valid @ModelAttribute Habilidades habilidades,
										BindingResult validaciones,
										HttpSession sesion){
		if(validaciones.hasErrors()) {
			return "agregarHabilidades.jsp";
		}
		
		Long id_usuario = (Long)sesion.getAttribute("id_usuario");
		Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorId(id_usuario);
		habilidades.setUsuario(usuario);
		this.servicioHabilidades.agregarHabilidades(habilidades);
		return "redirect:/inicio";
	}
	@GetMapping("/detalle/habilidades/{id}")
	public String desplegarDetalleHabilidades(@PathVariable Long id,
										  Model modelo,
										  HttpSession sesion) {
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
		Habilidades  detalleHabilidades = this.servicioHabilidades.obtenerUno(id);
		modelo.addAttribute("detalleHabilidades", detalleHabilidades);
		return "detalleHabilidades.jsp";
	}
	

 	@DeleteMapping("/habilidades/eliminar/{id}")
   	public String procesarEliminarHabilidades(@PathVariable("id") Long id) {
		this.servicioHabilidades.eliminarHabilidades(id);

     	  	return "redirect:/inicio";
   	}
}
		

