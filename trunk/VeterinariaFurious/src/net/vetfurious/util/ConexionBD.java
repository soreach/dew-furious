package net.vetfurious.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection obtenerConexion() throws SQLException {

		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost/VeterinariaFurious","vetuser", "vetuser");
			//con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=VeterinariaFurious","vetuser", "vetuser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
