package net.vetfurious.negocio;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


	public class ConexionBD {

	        public static Connection obtenerConexion() throws SQLException {

	                Connection con = null;
	                try {
	                        Class.forName("com.mysql.jdbc.Driver");
	                        con = DriverManager.getConnection("jdbc:mysql://localhost/tienda",
	                                                "root", "root");
	                } catch (ClassNotFoundException e) {
	                        e.printStackTrace();
	                } catch (Exception e) {
	                        e.printStackTrace();
	                }
	                return con;
	        }

	        
	}