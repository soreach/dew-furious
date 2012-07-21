package net.vetfurious.negocio;

import java.util.ArrayList;
import java.util.Collection;
import net.vetfurious.dao.PacienteDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Paciente;

public class AdmGestionPaciente {
        
//        public Collection<Paciente> buscarPorCodigoPaciente(String codigoPaciente) throws DAOExcepcion {
//                PacienteDAO dao = new PacienteDAO();
//                return listar();
//        }

        public Paciente insertar(String codigoDueno, String codigoPaciente, String especie, String raza, String genero, String tipoSangre, String esterilizado, String tamaño, String actividad, String peso, String fechaNacimiento)
                        throws DAOExcepcion {
                PacienteDAO dao = new PacienteDAO();

                Paciente vo = new Paciente();
                vo.setCodigoDueno(codigoDueno);
                vo.setCodigoPaciente(codigoPaciente);
                vo.setEspecie(especie);
                vo.setRaza(raza);
                vo.setGenero(genero);
                vo.setTipoSangre(tipoSangre);
                vo.setEsterilizado(esterilizado);
                vo.setTamaño(tamaño);
                vo.setActividad(actividad);
                vo.setPeso(peso);
                vo.setFechaNacimiento(fechaNacimiento);

                return dao.insertar(vo);
                
        }

//        public Paciente obtener(String codigoDueno, String codigoPaciente, String especie, String raza, String genero, String tipoSangre, String esterilizado, String tamaño, String actividad, String peso, String fechaNacimiento) throws DAOExcepcion {
        public Paciente obtener(String codigoDueno) throws DAOExcepcion {
            	 
        	PacienteDAO dao = new PacienteDAO();
                return dao.obtenerPaciente(codigoDueno);
        }

        public void eliminar(String codigoPaciente) throws DAOExcepcion {
                PacienteDAO dao = new PacienteDAO();
                eliminar(codigoPaciente);
        }

        public Paciente actualizar(String codigoDueno, String especie, String raza) throws DAOExcepcion {
                PacienteDAO dao = new PacienteDAO();

                Paciente vo = new Paciente();
                vo.setCodigoDueno(codigoDueno);
                vo.setEspecie(especie);
                vo.setRaza(raza);

                return dao.actualizar(vo);
        }

//        public Collection<Paciente> listar() throws DAOExcepcion {
        public ArrayList<Paciente> listar() throws DAOExcepcion {
                PacienteDAO dao = new PacienteDAO();
                return dao.listar();
        }


}
