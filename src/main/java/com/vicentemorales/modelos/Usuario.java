package com.vicentemorales.modelos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  
   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Habilidades> habilidades;
   
   @NotBlank(message = "Por favor proporciona tu nombre")
   @Size(min = 3, message = "Por favor propociona tu nombre")
   @Pattern(regexp = "^[a-zA-Z ]+$", message ="Ingrese Caracteres Validos")
   private String nombre;
  
   @NotBlank(message = "Por favor proporciona tu apellido")
   @Size(min = 3, message = "Por favor propociona tu apellido")
   @Pattern(regexp = "^^[a-zA-Z ]+$", message ="Ingrese Caracteres Validos")
   private String apellido;
   
   @NotBlank(message = "El correo es requerido.")
   @Email(message = "Por favor proporciona un correo válido.")
   private String correo;

   @NotBlank(message = "Por favor proporciona la constraseña.")
   @Size(min = 8, message = "El password necesita tener al menos 8 catacteres.")
   private String contrasena;
   
   @Transient
   private String confirmacionContrasena;
   @Column
   private LocalDateTime fechaCreacion;
   @Column
   private LocalDateTime fechaActualizacion;

	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Habilidades> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidades> habilidades) {
		this.habilidades = habilidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getConfirmacionContrasena() {
		return confirmacionContrasena;
	}

	public void setConfirmacionContrasena(String confirmacionContrasena) {
		this.confirmacionContrasena = confirmacionContrasena;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	@PrePersist
	protected void onCrete() {
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		fechaActualizacion = LocalDateTime.now();
	}

}