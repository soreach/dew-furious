package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

public interface IDoctor {

	/*
	public abstract Doctor insertar(String nombre, String paterno,
			String materno, String email, String telefono, String usuario)
			throws DAOExcepcion;

	public abstract Doctor obtener(int idCategoria) throws DAOExcepcion;

	public abstract Doctor actualizar(int doctorID, String nombre,
			String paterno, String materno, String email, String telefono,
			String usuario) throws DAOExcepcion;
			*/

	//@Override
	public abstract List<Doctor> listDoctores() throws DAOExcepcion;

}