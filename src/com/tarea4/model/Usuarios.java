package com.tarea4.model;

import java.util.Date;

public class Usuarios {

	private int id;
	private String contrasena_usuario;
	private String nombre_usuario;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private Date fecha_creacion;
	//
	public Usuarios() {
		
	}
	//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContrasena_usuario() {
		return contrasena_usuario;
	}
	public void setContrasena_usuario(String contrasena_usuario) {
		this.contrasena_usuario = contrasena_usuario;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	
}
