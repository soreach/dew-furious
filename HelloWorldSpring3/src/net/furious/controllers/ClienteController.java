package net.furious.controllers;

import java.io.IOException;
import net.vetfurious.excepcion.DAOExcepcion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.vetfurious.negocio.ICliente;
import net.vetfurious.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ClienteController {

	@Autowired
	private ICliente Cliente;
	
	@RequestMapping(value="/listarcliente.jsp")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Cliente> clientes = this.Cliente.listarprospectos();
				
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("clientes",clientes);
       
        return new ModelAndView("listarcliente", "model", myModel);

    }
	
	@RequestMapping(value = "/verRegistroCliente", method = RequestMethod.GET)
	public ModelAndView ingresar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevoCliente");
	}
	
	@RequestMapping(value = "/registrarCliente", method = RequestMethod.POST)
	public ModelAndView registroCliente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarCliente");
		
		Cliente oModelCliente = new Cliente();
		oModelCliente.setCodigo(request.getParameter("id"));
		oModelCliente.setNombre(request.getParameter("txtNombre"));
		oModelCliente.setApellidopaterno(request.getParameter("txtApellidoPaterno"));
		oModelCliente.setApellidomaterno(request.getParameter("txtApellidoMaterno"));
		oModelCliente.setCelular(request.getParameter("txtCelular"));
		oModelCliente.setDireccion(request.getParameter("txtDireccion"));
		oModelCliente.setEmail(request.getParameter("txtEmail"));
		oModelCliente.setImagen(request.getParameter("txtImagen"));
		oModelCliente.setTelefono(request.getParameter("txtTelefono"));
		
		try {
			Cliente.GrabarModificarProspecto(oModelCliente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}
	
	@RequestMapping(value = "/editarCliente", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Cliente oModelCliente = new Cliente();
		oModelCliente = Cliente.ObtenerProspecto(request.getParameter("id"));
		
		System.out.println("idCliente "+request.getParameter("id"));
		return new ModelAndView("editarCliente", "model", oModelCliente);
	}
	
	@RequestMapping(value = "/guardarModificacionCliente", method = RequestMethod.POST)
	public ModelAndView modificarCliente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarCliente");
		
		Cliente oModelCliente = new Cliente();
		oModelCliente.setCodigo(request.getParameter("id"));
		oModelCliente.setNombre(request.getParameter("txtNombre"));
		oModelCliente.setApellidopaterno(request.getParameter("txtApellidoPaterno"));
		oModelCliente.setApellidomaterno(request.getParameter("txtApellidoMaterno"));
		oModelCliente.setCelular(request.getParameter("txtCelular"));
		oModelCliente.setDireccion(request.getParameter("txtDireccion"));
		oModelCliente.setEmail(request.getParameter("txtEmail"));
		oModelCliente.setImagen(request.getParameter("txtImagen"));
		oModelCliente.setTelefono(request.getParameter("txtTelefono"));
		
		try {
			Cliente.GrabarModificarProspecto(oModelCliente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}
	
	@RequestMapping(value = "/eliminarCliente", method = RequestMethod.GET)
	public ModelAndView eliminarCliente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarCliente");
		
		Cliente oModelCliente = new Cliente();
		oModelCliente.setCodigo(request.getParameter("id"));
		oModelCliente.setNombre(request.getParameter("txtNombre"));
		oModelCliente.setApellidopaterno(request.getParameter("txtApellidoPaterno"));
		oModelCliente.setApellidomaterno(request.getParameter("txtApellidoMaterno"));
		oModelCliente.setCelular(request.getParameter("txtCelular"));
		oModelCliente.setDireccion(request.getParameter("txtDireccion"));
		oModelCliente.setEmail(request.getParameter("txtEmail"));
		oModelCliente.setImagen(request.getParameter("txtImagen"));
		oModelCliente.setTelefono(request.getParameter("txtTelefono"));
		
		try {
			Cliente.deleteprospecto(oModelCliente.getCodigo());
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}

	
	@RequestMapping(value = "/Menu", method = RequestMethod.GET)
	public ModelAndView IrMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Menu");
		//String RutaFile=request.getContextPath();
		//return new ModelAndView(RutaFile + "/index");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/CambiarCliente", method = RequestMethod.GET)
	public ModelAndView CambiarCliente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("CambiarCliente");
		
		Cliente oModelCliente = new Cliente();
		oModelCliente.setCodigo(request.getParameter("id"));
		
		try {
			Cliente.changeProspectoToCliente(oModelCliente.getCodigo());
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}

	@RequestMapping(value="/listarcliente2.jsp")
	public ModelAndView ListarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Cliente> clientes = this.Cliente.listClientes();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("clientes",clientes);
		
        return new ModelAndView("listarclienteC", "model", myModel);
        
    }
	
	@RequestMapping(value = "/eliminarClienteC", method = RequestMethod.GET)
	public ModelAndView eliminarClienteC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarClienteC");
		
		Cliente oModelCliente = new Cliente();
		oModelCliente.setCodigo(request.getParameter("id"));
	
		try {
			Cliente.deleteprospecto(oModelCliente.getCodigo());
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente2.jsp");
	}
	
	
	@RequestMapping(value = "/editarClienteC", method = RequestMethod.GET)
	public ModelAndView editarClienteC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Cliente oModelCliente = new Cliente();
		oModelCliente = Cliente.ObtenerProspecto(request.getParameter("id"));
		
		System.out.println("idCliente "+request.getParameter("id"));
		return new ModelAndView("editarClienteC", "model", oModelCliente);
	}
	
	@RequestMapping(value = "/guardarModificacionClienteC", method = RequestMethod.POST)
	public ModelAndView modificarClienteC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("guardarModificacionClienteC");
		
		Cliente oModelCliente = new Cliente();
		oModelCliente.setCodigo(request.getParameter("id"));
		oModelCliente.setNombre(request.getParameter("txtNombre"));
		oModelCliente.setApellidopaterno(request.getParameter("txtApellidoPaterno"));
		oModelCliente.setApellidomaterno(request.getParameter("txtApellidoMaterno"));
		oModelCliente.setCelular(request.getParameter("txtCelular"));
		oModelCliente.setDireccion(request.getParameter("txtDireccion"));
		oModelCliente.setEmail(request.getParameter("txtEmail"));
		oModelCliente.setImagen(request.getParameter("txtImagen"));
		oModelCliente.setTelefono(request.getParameter("txtTelefono"));
		
		try {
			Cliente.GrabarModificarProspecto(oModelCliente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente2.jsp");
	}
}
