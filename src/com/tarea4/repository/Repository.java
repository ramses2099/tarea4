package com.tarea4.repository;

import java.sql.SQLException;
import java.util.List;

import com.tarea4.model.Usuarios;

public interface Repository {

	public int add(Usuarios user)throws SQLException;
	public void delete(int id)throws SQLException;
	public Usuarios getUsuario(int id)throws SQLException;
	public List<Usuarios> getUsuarios()throws SQLException;
	public boolean isValidUser(String userName, String Password)throws SQLException; 
	
}
