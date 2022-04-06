package com.tarea4.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static Connection con =null;
	
	private DatabaseConnection() {}
	
	static {
		String url ="jdbc:mysql://localhost:3306/dbtarea4";
		String user ="root";
		String pass="";
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
				
	}
	//	
	public static Connection getConnection() {
		return con;
	}
	
}
