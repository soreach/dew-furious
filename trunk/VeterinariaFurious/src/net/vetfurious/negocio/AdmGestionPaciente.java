package net.vetfurious.negocio;

import java.util.Collection;

import net.vetfurious.dao.PacienteDAO;

public class AdmGestionPaciente {
	
	AdmGestionPaciente codigoDueño = new AdmGestionPaciente();
	AdmGestionPaciente codigoPaciente = new AdmGestionPaciente();
	AdmGestionPaciente especiePaciente = new AdmGestionPaciente();
	AdmGestionPaciente razaPaciente = new AdmGestionPaciente();
	public void insertar(String string, String string2, String string3,
			String string4, String string5, String string6, String string7,
			String string8, String string9, String string10, String string11) {
		// TODO Auto-generated method stub
		
	}

	
	public Collection<Paciente> buscarPorCodigoPaciente(String codigoPaciente)
			throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		return dao.listar();
	}

	public Paciente insertar(String codigoDueno, String codigoPaciente)
			throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();

		Paciente vo = new Paciente();
		vo.setcodigoDueno(codigoDueno);
		vo.setcodigoPaciente(codigoPaciente);

		return dao.insertar(vo);
	}

	public Paciente obtener(String codigoPaciente) throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		return dao.obtener(codigoPaciente);
	}

	public void eliminar(String codigoPaciente) throws DAOExcepcion {
		codigoPacienteDAO dao = new PacienteDAO();
		dao.eliminar(codigoPaciente);
	}

	public Paciente actualizar(String codigoDueno, String codigoPaciente, String especiePaciente, String razaPaciente,  
			String generoPaciente, String tipoSangrePaciente, String estirilizado) throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();

		Paciente vo = new Paciente();
		vo.setCodigoDueno(codigoDueno);
		vo.setCodigoPaciente(codigoPaciente);
		vo.setEspeciePaciente(especiePaciente);

		return dao.actualizar(vo);
	}

	public Collection<Paciente> listar() throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		return dao.listar();
	}


}
