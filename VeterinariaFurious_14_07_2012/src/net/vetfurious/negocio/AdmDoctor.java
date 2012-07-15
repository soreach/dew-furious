package net.vetfurious.negocio;

import java.util.ArrayList;

import net.vetfurious.dao.DoctorDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

public class AdmDoctor {

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
	
	public Doctor obtenerDoctor(int idDoctor) throws DAOExcepcion  {
		Doctor objDoctor=null;
		DoctorDAO objDoctorDAO=new DoctorDAO();
		if(objDoctorDAO.existeDoctor(idDoctor)==1)
		{
			objDoctor=(Doctor)objDoctorDAO.obtenerDoctor(idDoctor);
		}
		return objDoctor;
	}

	
}
