package net.vetfurious.test;

import org.junit.Test;
import junit.framework.Assert;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;
import net.vetfurious.negocio.AdmDoctor;

public class AdmDoctorTest {

	@Test
	public void insertarTest() {

		AdmDoctor negocio = new AdmDoctor();

		try {
			negocio.insertar("Ebert", "Pasquel", "Paucar", "epasquel_20@hotmail.com", "123244", "ebert");

			Doctor nuevo = negocio.obtener(7);

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

			Doctor nuevo = negocio.obtener(1);

			Assert.assertEquals("ebert2", nuevo.getUsuario());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}
	
}
