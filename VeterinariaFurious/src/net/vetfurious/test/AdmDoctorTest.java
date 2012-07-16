package net.vetfurious.test;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;
import net.vetfurious.negocio.AdmDoctor;
import java.util.ArrayList;

public class AdmDoctorTest {

	@Test
	public void insertarTest() {

		AdmDoctor negocio = new AdmDoctor();

		try {
			negocio.insertar("Ebert", "Pasquel", "Paucar", "epasquel_20@hotmail.com", "123244", "ebert");

			Doctor nuevo = negocio.obtenerDoctor(7);

			Assert.assertEquals("ebert", nuevo.getUsuario());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {

		AdmDoctor negocio = new AdmDoctor();

		try {

			negocio.actualizar(1,"Ebert", "Pasquel", "Paucar", "epasquel_20@hotmail.com", "123244", "ebert2");

			Doctor nuevo = negocio.obtenerDoctor(1);

			Assert.assertEquals("ebert2", nuevo.getUsuario());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}
	
	@Test
	public void listarDoctorTest() {				
		AdmDoctor objAdmDoctor= new AdmDoctor();
		ArrayList<Doctor> Lista;
		try {
			Lista = (ArrayList<Doctor>)objAdmDoctor.listarDoctores();
			assertTrue(Lista.size()>0);
			
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el listado de doctores: " + e.getMessage());
		}
	}
	
	@Test
	public void eliminarDoctorTest() {
		int idDoctor=3;
				
		AdmDoctor objAdmDoctor= new AdmDoctor();
		try {
			objAdmDoctor.eliminarDoctor(idDoctor);
			
			Doctor objNewDoctor=(Doctor)objAdmDoctor.obtenerDoctor(idDoctor);
			
			assertNull(objNewDoctor);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el eliminar Doctor: " + e.getMessage());
		}
		
		
	}
}
