package net.vetfurious.negocio;


import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;

public class AdmLogin implements ILogin{

	@Override
	public Login ObtenerCredenciales(Login _login) throws DAOExcepcion {
		Login objLogin = null;
		LoginDAO objLoginDAO = new LoginDAO();
		
		objLogin = objLoginDAO.DAOobtenercredenciales(_login);
		
		return objLogin;
	}


}
