package net.takumi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_takumi?useTimezOne=true&serverTimezone=UTC";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
			System.out.println("Conexión establecida");
		} catch(ClassNotFoundException ex) {
			System.out.println("No hay driver");
		} catch(SQLException ex) {
			System.out.println("Error con la BD");
		} return con;
	}	

}
