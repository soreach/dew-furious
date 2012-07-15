package net.vetfurious.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;
import net.vetfurious.negocio.AdmDoctor;

import org.junit.Test;

public class DoctorTest {

	
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
