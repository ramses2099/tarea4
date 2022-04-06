package com.tarea4.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarea4.model.Usuarios;
import com.tarea4.utils.DatabaseConnection;

public class UserRepository implements Repository {

	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(Usuarios user) throws SQLException {
		String Query = "INSERT INTO `usuarios`(`nombre_usuario`, `contrasena_usuario`, `nombre`, `apellido`, `telefono`, `email`, `fecha_creacion`) VALUES (?,?,?,?,?,?,NOW())";
		PreparedStatement ps = con.prepareStatement(Query);
		ps.setString(1, user.getNombre_usuario());
		ps.setString(2, user.getContrasena_usuario());
		ps.setString(3, user.getNombre());
		ps.setString(4, user.getApellido());
		ps.setString(5, user.getTelefono());
		ps.setString(6, user.getEmail());

		int rs = ps.executeUpdate();
		
		return rs;
	}

	@Override
	public void delete(int id) throws SQLException {
		String Query = "DELETE FROM `usuarios` WHERE `id` = ?";
		PreparedStatement ps = con.prepareStatement(Query);
		ps.setInt(1, id);
		 ps.executeUpdate();	
	}

	@Override
	public Usuarios getUsuario(int id) throws SQLException {
		Usuarios user = null;
		String Query = "SELECT * FROM `usuarios` WHERE `id` = ?";
		PreparedStatement ps = con.prepareStatement(Query);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user = new Usuarios();

			// `id``nombre_usuario``nombre``apellido``telefono``email`
			user.setId(rs.getInt("id"));
			user.setNombre_usuario(rs.getString("nombre_usuario"));
			user.setNombre(rs.getString("nombre"));
			user.setApellido(rs.getString("apellido"));
			user.setTelefono(rs.getString("telefono"));
			user.setEmail(rs.getString("email"));

		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public List<Usuarios> getUsuarios() throws SQLException {
		List<Usuarios> lsUsuario = new ArrayList<>();
		String Query = "SELECT * FROM `usuarios`";
		PreparedStatement ps = con.prepareStatement(Query);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Usuarios user = new Usuarios();

			// `id``nombre_usuario``nombre``apellido``telefono``email`
			user.setId(rs.getInt("id"));
			user.setNombre_usuario(rs.getString("nombre_usuario"));
			user.setNombre(rs.getString("nombre"));
			user.setApellido(rs.getString("apellido"));
			user.setTelefono(rs.getString("telefono"));
			user.setEmail(rs.getString("email"));
			//
			lsUsuario.add(user);

		}
		// TODO Auto-generated method stub
		return lsUsuario;
	}

	@Override
	public boolean isValidUser(String userName, String Password) throws SQLException {
		// TODO Auto-generated method stub
		boolean check = false;

		String Query = "SELECT * FROM `usuarios` WHERE `nombre_usuario` = ? and `contrasena_usuario` = ?; ";
		PreparedStatement ps = con.prepareStatement(Query);
		ps.setString(1, userName);
		ps.setString(2, Password);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			check = true;
		}

		return check;
	}

}
