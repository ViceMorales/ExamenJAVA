package com.vicentemorales.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Login {
	@NotBlank(message = "Por favor proporciona tu correo")
	@Size(min = 3, message = "Por favor propociona tu correo")
	private String correo;
	
	private String contrasena;

	public Login() {
		super();
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
	
