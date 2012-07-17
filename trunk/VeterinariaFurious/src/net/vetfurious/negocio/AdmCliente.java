package net.vetfurious.negocio;

import java.util.ArrayList;
import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;

public class AdmCliente {

	

	public Cliente ObtenerProspecto(String codigo) throws DAOExcepcion  {
		Cliente objCliente=null;
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexisteprospecto(codigo)==1){
			objCliente=(Cliente)objClienteDAO.DAOobtenerprospecto(codigo);
		}
		return objCliente;
	}

	

	public void deleteprospecto(String codigo) throws DAOExcepcion{
		ClienteDAO objClienteDAO=new ClienteDAO();
		int countcliente= objClienteDAO.DAOexisteprospecto(codigo);
		
		if(countcliente==1){
			objClienteDAO.DAOdeleteprospecto(codigo);
		}
		
	}
	
	
	public Boolean changeProspectoToCliente(String codigo) throws DAOExcepcion
	{
		Boolean answer = false;
		
		ClienteDAO objClienteDAO =  new ClienteDAO();
		int clienteExists = objClienteDAO.DAOexisteprospecto(codigo);
		
		if(clienteExists == 1)
		{
			if(objClienteDAO.DAOchangeProspectoToCliente(codigo)) answer = true;
		}
		
		return answer; 
	}
	
	public ArrayList<Cliente> listClientes() throws DAOExcepcion
	{
		ClienteDAO objClienteDAO=new ClienteDAO();
		return objClienteDAO.DAOlistClientes();
	}

	public ArrayList<Cliente> listarprospectos() throws DAOExcepcion{
		ClienteDAO objClienteDAO=new ClienteDAO();
		return objClienteDAO.DAOlistarprospectos();
	}

	public void GrabarModificarProspecto(String codigo, String nombre,
			String apellidopaterno, String apellidomaterno, String email,
			String direccion, String imagen, String telefono, String celular) throws DAOExcepcion{
		
		Cliente objCliente=new Cliente(codigo,nombre,apellidopaterno,apellidomaterno,email,direccion,imagen, telefono, celular);
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexisteprospecto(codigo)==0){
			String newcodigo=(objClienteDAO.DAOgetlastcodigo());
			objCliente.setCodigo(newcodigo);
			objClienteDAO.DAOgrabarprospecto(objCliente);
		}
		if(objClienteDAO.DAOexisteprospecto(codigo)==1){
			objClienteDAO.DAOmodificarprospecto(objCliente);
		}
		
	}


}
