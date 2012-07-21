package net.vetfurious.test;

//        import java.util.Collection;
      

        import static org.junit.Assert.*;
        import org.junit.Test;
        import junit.framework.Assert;


        import net.vetfurious.excepcion.DAOExcepcion;
        import net.vetfurious.modelo.Paciente;
        import java.util.ArrayList;
        import net.vetfurious.negocio.AdmGestionPaciente;

        public class GestionPacienteTest {
                        
//                    @Test
                        public void insertarTest() {

                                AdmGestionPaciente paciente = new AdmGestionPaciente();
                                
                                try {
                                        paciente.insertar("Cliente001", "Paciente001", "Perro", "Pastor Aleman", "Macho", "Orh+", "Si", "Grande", "Media", "25kg", "02/04/2000");

                                        Paciente nuevo = paciente.obtener("Cliente001");

       //                                 Assert.assertEquals("Pastor Aleman", nuevo.getRaza());

                                } catch (DAOExcepcion e) {
         //                               Assert.fail("Fallo la inserción: " + e.getMessage());
                                }
                        }

//                    @Test
                        public void actualizarTest() {

                                AdmGestionPaciente paciente = new AdmGestionPaciente();

                                try {

                                        paciente.actualizar("Cliente001", "Gato", "Angora");

                                        Paciente nuevo = paciente.obtener("Cliente001");

           //                             Assert.assertEquals("Angora", nuevo.getRaza());

                                } catch (DAOExcepcion e) {

                                        Assert.fail("Falló la actualización: " + e.getMessage());

                                }
                        }
                        
//                    @Test
                        public void listarTest() {

                                AdmGestionPaciente paciente = new AdmGestionPaciente();

                                try {
                                        ArrayList<Paciente> listado = paciente.listar();

                                        System.out.println(listado.size());

                                        Assert.assertTrue(listado.size() > 0);

                                } catch (DAOExcepcion e) {

                                        Assert.fail("Falló el listado: " + e.getMessage());

                                }

                        }

//                        @Test
                        public void eliminarTest() {

                                AdmGestionPaciente paciente = new AdmGestionPaciente();

                                try {

                                        paciente.eliminar("Cliente001");

                                        Paciente nuevo = paciente.obtener("Cliente001");

                                        Assert.assertEquals(null, nuevo.getDescripcion());

                                } catch (DAOExcepcion e) {

                                        Assert.fail("Falló la eliminición: " + e.getMessage());

                                }

                        }

                }
