package net.vetfurious.test;

//	package net.vetfurious.test;

//	import java.util.Collection;
//	import junit.framework.Assert;
//	import net.vetfurious.negocio.AdmGestionPaciente;

import net.vetfurious.negocio.AdmGestionPaciente;	
//	import org.junit.Test;

	public class GestionPacienteTest {
	                
//	              @Test
	                public void insertarTest() {

	                        AdmGestionPaciente paciente = new AdmGestionPaciente();
	                        
	                        try {
	                                paciente.insertar("Cliente001", "Paciente001", "Perro", "Pastor Aleman", "Macho", "Orh+", "Si", "Grande", "Media", "25kg", "02/04/2000");

	                                Paciente nuevo = paciente.obtener();

	                                Assert.assertEquals("Pastor Aleman", nuevo.getRaza());

	                        } catch (DAOExcepcion e) {
	                                Assert.fail("Fallo la inserción: " + e.getMessage());
	                        }
	                }

//	              @Test
	                public void actualizarTest() {

	                        AdmGestionPaciente paciente = new AdmGestionPaciente();

	                        try {

	                                paciente.actualizar(2, "Gato", "Angora");

	                                Paciente nuevo = negocio.obtener(3);

	                                Assert.assertEquals("Angora", nuevo.getRaza());

	                        } catch (DAOExcepcion e) {

	                                Assert.fail("Falló la actualización: " + e.getMessage());

	                        }
	                }
	                
//	              @Test
	                public void listarTest() {

	                        AdmGestionPaciente paciente = new AdmGestionPaciente();

	                        try {
	                                Arraylist<Paciente> listado = paciente.listar();

	                                System.out.println(listado.size());

	                                Assert.assertTrue(listado.size() > 0);

	                        } catch (DAOExcepcion e) {

	                                Assert.fail("Falló el listado: " + e.getMessage());

	                        }

	                }

	                @Test
	                public void eliminarTest() {

	                        AdmGestionPaciente paciente = new AdmGestionPaciente();

	                        try {

	                                paciente.eliminar(6);

	                                Paciente nuevo = negocio.obtener(6);

	                                Assert.assertEquals(null, nuevo.getDescripcion());

	                        } catch (DAOExcepcion e) {

	                                Assert.fail("Falló la eliminición: " + e.getMessage());

	                        }

	                }

	        }

