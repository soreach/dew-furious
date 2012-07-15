package net.vetfurious.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.Assert;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.*;
import net.vetfurious.negocio.AdmCliente;
import net.vetfurious.util.ConexionBD;

import org.junit.Test;

public class ClienteTest {

	
	
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
	public void cliente() {
		String codigo="0";
		String nombre="jose";
		String apellidopaterno="zamudio";
		String apellidomaterno="risco";
		String email="libra5100@hotmail.com";
		String direccion="SMP";
		String imagen="";
		String telefono="5342031";
		String celular="997480042";
		
		Cliente objCliente= new Cliente(codigo,nombre,apellidopaterno,apellidomaterno,email,direccion,imagen,telefono,celular);
		
		assertTrue(objCliente.getNombre().equals(nombre));
		assertTrue(objCliente.getEmail().equals(email));
		assertTrue(objCliente.getDireccion().equals(direccion));
		assertTrue(objCliente.getImagen().equals(imagen));
		assertTrue(objCliente.getTelefono().equals(telefono));
		assertTrue(objCliente.getCelular().equals(celular));
	}
	
	@Test
	public void grabarcliente() {
		String codigo="0";
		String nombre="jose";
		String apellidopaterno="zamudio";
		String apellidomaterno="risco";
		String email="libra5100@hotmail.com";
		String direccion="SMP";
		String imagen="";
		String telefono="5342031";
		String celular="997480042";
		
		
	    AdmCliente objAdmCliente= new AdmCliente();
	    try {
			objAdmCliente.GrabarModificarCliente(codigo,nombre,apellidopaterno,apellidomaterno,email,direccion,imagen,telefono,celular);
		
			Cliente objNewCliente=(Cliente)objAdmCliente.ObtenerCliente("1");
		    assertNotNull(objNewCliente);
		    
	    } catch (DAOExcepcion e) {

	    	Assert.fail("Falló el grabar: " + e.getMessage());
		}
	    
	    
	}
	
	
	@Test
	public void modificarcliente() {
		String codigo="1";
		String nombre="jose2";
		String apellidopaterno="zamudio2";
		String apellidomaterno="risco2";
		String email="libra2033@hotmail.com";
		String direccion="SMP";
		String imagen="";
		String telefono="5342031";
		String celular="997480042";
		
		AdmCliente objAdmCliente= new AdmCliente();
		try {
			objAdmCliente.GrabarModificarCliente(codigo,nombre,apellidopaterno,apellidomaterno,email,direccion,imagen,telefono,celular);
		
			Cliente objNewCliente=(Cliente)objAdmCliente.ObtenerCliente("1");
			assertTrue(objNewCliente.getNombre().equals(nombre));
			assertTrue(objNewCliente.getApellidopaterno().equals(apellidopaterno));
			assertTrue(objNewCliente.getApellidomaterno().equals(apellidomaterno));
			assertTrue(objNewCliente.getEmail().equals(email));
			assertTrue(objNewCliente.getDireccion().equals(direccion));
			assertTrue(objNewCliente.getImagen().equals(imagen));
			assertTrue(objNewCliente.getTelefono().equals(telefono));
			assertTrue(objNewCliente.getCelular().equals(celular));
		
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el modificar: " + e.getMessage());
		}
		
		
	}
	
	@Test
	public void deletecliente() {
		String codigo="3";
				
		AdmCliente objAdmCliente= new AdmCliente();
		try {
			objAdmCliente.deletecliente(codigo);
			
			Cliente objNewCliente=(Cliente)objAdmCliente.ObtenerCliente("3");
			
			assertNull(objNewCliente);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el delete: " + e.getMessage());
		}
		
		
	}
	
	
	@Test
	public void listarcliente() {
				
		AdmCliente objAdmCliente= new AdmCliente();
		ArrayList<Cliente> Lista;
		try {
			Lista = (ArrayList<Cliente>)objAdmCliente.listarclientes();
			assertTrue(Lista.size()>0);
			
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		
		
		
		
	}
}
