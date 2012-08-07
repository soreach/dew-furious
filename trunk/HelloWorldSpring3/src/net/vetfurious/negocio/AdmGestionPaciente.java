package net.vetfurious.negocio;

import java.util.List;
import org.springframework.stereotype.Service;
import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;

@Service
public class AdmGestionPaciente implements IPaciente {
        

        @Override
		public void insertarPaciente(String codigoDueno, String codigoPaciente, String especie, 
				String raza, String genero, String tipoSangre, String esterilizado, String tamano, 
				String actividad, String peso, String fechaNacimiento) throws DAOExcepcion {
        	
                Paciente objPaciente = new Paciente(codigoDueno, codigoPaciente, especie, raza, genero, tipoSangre, esterilizado, tamano, actividad, peso, fechaNacimiento);
                PacienteDAO objPacienteDAO = new PacienteDAO();
                
                objPaciente.setCodigoDueno(codigoDueno);
                objPaciente.setCodigoPaciente(codigoPaciente);
                objPaciente.setEspecie(especie);
                objPaciente.setRaza(raza);
                objPaciente.setGenero(genero);
                objPaciente.setTipoSangre(tipoSangre);
                objPaciente.setEsterilizado(esterilizado);
                objPaciente.setTamano(tamano);
                objPaciente.setActividad(actividad);
                objPaciente.setPeso(peso);
                objPaciente.setFechaNacimiento(fechaNacimiento);
            	objPacienteDAO.DAOinsertarPacientes(objPaciente);
           }

        @Override
		public Paciente obtenerPaciente(String codigoDueno) throws DAOExcepcion {
            	 
        	PacienteDAO dao = new PacienteDAO();
                return dao.obtenerPaciente(codigoDueno);
        }

        @Override
		public void eliminarPaciente(String codigoDueno) throws DAOExcepcion {
                PacienteDAO objPaciente = new PacienteDAO();
                objPaciente.eliminarPaciente(codigoDueno);
        }

        @Override
		public Paciente actualizarPaciente(String codigoDueno, String codigoPaciente, String especie, 
				String raza, String genero,	String tipoSangre, String esterilizado, String tamano,
				String actividad, String peso, String fechaNacimiento) throws DAOExcepcion {
                PacienteDAO dao = new PacienteDAO();

                Paciente objPaciente = new Paciente();
                objPaciente.setCodigoDueno(codigoDueno);
                objPaciente.setEspecie(especie);
                objPaciente.setRaza(raza);

                return dao.actualizar(objPaciente);
        }

      
        @Override
		public List<Paciente> listarPacientes() throws DAOExcepcion {
                PacienteDAO objPacienteDAO = new PacienteDAO();
                return objPacienteDAO.listarPacientes();
        }

        @Override
        public void insertar(Paciente oModelPaciente) {
        	// TODO Auto-generated method stub
	
        }
}
