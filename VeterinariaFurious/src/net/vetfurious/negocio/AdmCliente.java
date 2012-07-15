package net.vetfurious.negocio;

import java.util.ArrayList;
import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;

public class AdmCliente {

	

	public Cliente ObtenerCliente(String codigo) throws DAOExcepcion  {
		Cliente objCliente=null;
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexistecliente(codigo)==1){
			objCliente=(Cliente)objClienteDAO.DAOobtenercliente(codigo);
		}
		return objCliente;
	}

	

	public void deletecliente(String codigo) throws DAOExcepcion{
		ClienteDAO objClienteDAO=new ClienteDAO();
		int countcliente= objClienteDAO.DAOexistecliente(codigo);
		
		if(countcliente==1){
			objClienteDAO.DAOdeletecliente(codigo);
		}
		
	}

	public ArrayList<Cliente> listarclientes() throws DAOExcepcion{
		ClienteDAO objClienteDAO=new ClienteDAO();
		return objClienteDAO.DAOlistarclientes();
	}

	public void GrabarModificarCliente(String codigo, String nombre,
			String apellidopaterno, String apellidomaterno, String email,
			String direccion, String imagen, String telefono, String celular) throws DAOExcepcion{
		
		Cliente objCliente=new Cliente(codigo,nombre,apellidopaterno,apellidomaterno,email,direccion,imagen, telefono, celular);
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexistecliente(codigo)==0){
			String newcodigo=(objClienteDAO.DAOgetlastcodigo());
			objCliente.setCodigo(newcodigo);
			objClienteDAO.DAOgrabarcliente(objCliente);
		}
		if(objClienteDAO.DAOexistecliente(codigo)==1){
			objClienteDAO.DAOmodificarcliente(objCliente);
		}
		
	}


}
