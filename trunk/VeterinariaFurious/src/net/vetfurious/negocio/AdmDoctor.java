package net.vetfurious.negocio;

import java.util.ArrayList;

import net.vetfurious.dao.DoctorDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

public class AdmDoctor {

	public Doctor insertar(String nombre, String paterno, String materno, String email, String telefono, String usuario)
			throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();

		Doctor vo = new Doctor();
		vo.setNombre(nombre);
		vo.setPaterno(paterno);
		vo.setMaterno(materno);
		vo.setEmail(email);
		vo.setTelefono(telefono);
		vo.setUsuario(usuario);

		return dao.insertar(vo);
	}

	public Doctor obtenerDoctor(int idDoctor) throws DAOExcepcion  {
		Doctor objDoctor=null;
		DoctorDAO objDoctorDAO=new DoctorDAO();
		if(objDoctorDAO.existeDoctor(idDoctor)==1)
		{
			objDoctor=(Doctor)objDoctorDAO.obtenerDoctor(idDoctor);
		}
		return objDoctor;
	}
	
	public Doctor actualizar(int doctorID, String nombre, String paterno, String materno, String email, String telefono, String usuario) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();

		Doctor vo = new Doctor();
		vo.setDoctorID(doctorID);
		vo.setNombre(nombre);
		vo.setPaterno(paterno);
		vo.setMaterno(materno);
		vo.setEmail(email);
		vo.setTelefono(telefono);
		vo.setUsuario(usuario);

		return dao.actualizar(vo);
	}
	
	public ArrayList<Doctor> listarDoctores() throws DAOExcepcion{
		DoctorDAO objDoctorDAO=new DoctorDAO();
		return objDoctorDAO.listarDoctores();
	}
	
	public void eliminarDoctor(int idDoctor) throws DAOExcepcion{
		DoctorDAO objDoctorDAO=new DoctorDAO();
		int countDoctor= objDoctorDAO.existeDoctor(idDoctor);
		
		if(countDoctor==1){
			objDoctorDAO.eliminarDoctor(idDoctor);
		}	
	}
}
