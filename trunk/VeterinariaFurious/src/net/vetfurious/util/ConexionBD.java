package net.vetfurious.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection obtenerConexion() throws SQLException {

		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433/VeterinariaFurious");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=VeterinariaFurious;user=vetuser;password=vetuser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
