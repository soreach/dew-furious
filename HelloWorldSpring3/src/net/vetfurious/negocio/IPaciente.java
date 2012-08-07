package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Paciente;

public interface IPaciente {

	public abstract void insertarPaciente(String codigoDueno,
			String codigoPaciente, String especie, String raza, String genero,
			String tipoSangre, String esterilizado, String tamano,
			String actividad, String peso, String fechaNacimiento)
			throws DAOExcepcion;
	public abstract Paciente obtenerPaciente(String codigoDueno) throws DAOExcepcion;

	public abstract void eliminarPaciente(String codigoDueno) throws DAOExcepcion;

	public abstract Paciente actualizarPaciente(String codigoDueno, 
			String codigoPaciente, String especie, String raza, String genero,
			String tipoSangre, String esterilizado, String tamano,
			String actividad, String peso, String fechaNacimiento) throws DAOExcepcion;

	public abstract List<Paciente> listarPacientes() throws DAOExcepcion;
	
	public abstract void insertar(net.vetfurious.modelo.Paciente oModelPaciente);

}