package net.vetfurious.negocio;

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

	public Doctor obtener(int idCategoria) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.obtener(idCategoria);
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
	
}
