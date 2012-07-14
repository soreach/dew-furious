package trastienda.test;

import java.util.Collection;
import junit.framework.Assert;
import org.junit.Test;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Categoria;
import trastienda.negocio.GestionCategorias;


public class GestionCategoriasTest {
	
//	@Test
	public void insertarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {
			negocio.insertar("Electr�nicos", "Categoria de electr�nicos");

			Categoria nuevo = negocio.obtener(7);

			Assert.assertEquals("Categoria de electr�nicos", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserci�n: " + e.getMessage());
		}
	}

//	@Test
	public void actualizarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {

			negocio.actualizar(6, "Electr�nicos", "Categoria de electr�nicos 2");

			Categoria nuevo = negocio.obtener(6);

			Assert.assertEquals("Categoria de electr�nicos 2", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {

			Assert.fail("Fall� la actualizaci�n: " + e.getMessage());

		}
	}
	
//	@Test
	public void listarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {
			Collection<Categoria> listado = negocio.listar();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Fall� el listado: " + e.getMessage());

		}

	}

	@Test
	public void eliminarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {

			negocio.eliminar(6);

			Categoria nuevo = negocio.obtener(6);

			Assert.assertEquals(null, nuevo.getDescripcion());

		} catch (DAOExcepcion e) {

			Assert.fail("Fall� la eliminici�n: " + e.getMessage());

		}

	}


}
