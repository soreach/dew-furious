package net.vetfurious.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vetfurious.dao.DoctorDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

@Service 
public class AdmDoctor implements IDoctor {

/*
	@Override
	public Doctor insertar(String nombre, String paterno, String materno, String email, String telefono, String usuario)
			throws DAOExcepcion {
		IDoctor dao = new DoctorDAO();

		Doctor vo = new Doctor();
		vo.setNombre(nombre);
		vo.setPaterno(paterno);
		vo.setMaterno(materno);
		vo.setEmail(email);
		vo.setTelefono(telefono);
		vo.setUsuario(usuario);

		return dao.insertar(vo);
	}


	@Override
	public Doctor obtener(int idCategoria) throws DAOExcepcion {
		IDoctor dao = new DoctorDAO();
		return dao.obtener(idCategoria);
	}

	@Override
	public Doctor actualizar(int doctorID, String nombre, String paterno, String materno, String email, String telefono, String usuario) throws DAOExcepcion {
		IDoctor dao = new DoctorDAO();

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
	*/
	
	//@Override
	/* (non-Javadoc)
	 * @see net.vetfurious.negocio.IDoctor#listDoctores()
	 */
	@Override
	public List<Doctor> listDoctores() throws DAOExcepcion{
		DoctorDAO objDoctorDAO=new DoctorDAO();
		return objDoctorDAO.DAOlistDoctores();
	}
	
}
