package net.vetfurious.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import junit.framework.Assert;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Login;
import net.vetfurious.negocio.AdmLogin;
import net.vetfurious.util.ConexionBD;

import org.junit.Test;

public class LoginTest {		
		
		//@Test
		public void test() {
			fail("Not yet implemented");
		}

		@Test
		public void conexion() {
			Connection cn =null;
			try {
				 cn= ConexionBD.obtenerConexion();
				assertNotNull(cn);
			} catch (SQLException e) {
				Assert.fail("Falló la coneccion: " + e.getMessage());
			}
		}
		
		@Test
		public void Login1() {
			String usuario="victor";
			String password="1234";
			
			Login objLogin= new Login(usuario,password);
			
			assertTrue(objLogin.getUsuario().equals(usuario));
			assertTrue(objLogin.getPassword().equals(password));
		}
		
		@Test
		public void Login2() {
			int usuarioid = 1;
			String usuario="victor";
			String password="1234";
			String nombre = "Victor Aguayo";
			String administrador = "1";
			
			
			Login objLogin= new Login(usuarioid,usuario,password,nombre,administrador);
			
			assertTrue(objLogin.getUsuarioID()==usuarioid);
			assertTrue(objLogin.getUsuario().equals(usuario));
			assertTrue(objLogin.getPassword().equals(password));
			assertTrue(objLogin.getNombre().equals(nombre));
			assertTrue(objLogin.getAdministrador().equals(administrador));
		}
		
		@Test
		public void ObtenerCredenciales() {
			String usuario="victor";
			String password="1234";
			
			
			Login oLogin= new Login(usuario,password);
			AdmLogin objLogin = new AdmLogin(); 
		    try {
		    		oLogin = objLogin.ObtenerCredenciales(oLogin);
			
			    assertNotNull(objLogin);
			    
		    } catch (DAOExcepcion e) {

		    	Assert.fail("Falló el grabar: " + e.getMessage());
			}
		    
		    
		}
		
}
