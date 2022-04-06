package com.tarea4.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tarea4.model.Usuarios;
import com.tarea4.utils.DatabaseConnection;

public class UserRepository implements Repository {
	
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(Usuarios user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Usuarios user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuarios getUsuario(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> getUsuarios() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidUser(String userName, String Password) throws SQLException {
		// TODO Auto-generated method stub
		boolean check = false;
		
		String Query ="SELECT * FROM `usuarios` WHERE `nombre_usuario` = ? and `contrasena_usuario` = ?; ";
		PreparedStatement ps = con.prepareStatement(Query);
		ps.setString(1, userName );
		ps.setString(2, Password);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			check = true;
		}
		
		return check;
	}

	
}
