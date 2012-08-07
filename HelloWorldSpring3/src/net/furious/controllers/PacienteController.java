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
import net.vetfurious.negocio.IPaciente;
import net.vetfurious.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PacienteController {

	@Autowired
	private IPaciente Paciente;
	
	@RequestMapping(value="/listarpaciente.jsp")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Paciente> pacientes = this.Paciente.listarPacientes();
				
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("pacientes",pacientes);
       
        return new ModelAndView("listarpaciente", "model", myModel);

    }
	
	@RequestMapping(value = "/verRegistroPaciente", method = RequestMethod.GET)
	public ModelAndView ingresar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevoPaciente");
	}
	
	@RequestMapping(value = "/registrarPaciente", method = RequestMethod.POST)
	public ModelAndView registroPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarPaciente");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigoDueno(request.getParameter("txtCodigoDueno"));
		oModelPaciente.setCodigoPaciente(request.getParameter("txtCodigoPaciente"));
		oModelPaciente.setEspecie(request.getParameter("txtEspecie"));
		oModelPaciente.setRaza(request.getParameter("txtRaza"));
		oModelPaciente.setGenero(request.getParameter("txtGenero"));
		oModelPaciente.setTipoSangre(request.getParameter("txtTipoSangre"));
		oModelPaciente.setEsterilizado(request.getParameter("txtEsterilizado"));
		oModelPaciente.setTamano(request.getParameter("txtTamano"));
		oModelPaciente.setActividad(request.getParameter("txtActividad"));
		oModelPaciente.setPeso(request.getParameter("txtPeso"));
		oModelPaciente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
		try {
			Paciente.insertar(oModelPaciente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}
	
	@RequestMapping(value = "/editarPaciente", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Paciente oModelPaciente = new Paciente();
		oModelPaciente = Paciente.obtenerPaciente(request.getParameter("codigoDueno"));
		
		System.out.println("idPaciente "+request.getParameter("codigoDueno"));
		return new ModelAndView("editarPaciente", "model", oModelPaciente);
	}
	
	@RequestMapping(value = "/guardarModificacionPaciente", method = RequestMethod.POST)
	public ModelAndView modificarPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarPaciente");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigoDueno(request.getParameter("txtCodigoDueno"));
		oModelPaciente.setCodigoPaciente(request.getParameter("txtCodigoPaciente"));
		oModelPaciente.setEspecie(request.getParameter("txtEspecie"));
		oModelPaciente.setRaza(request.getParameter("txtRaza"));
		oModelPaciente.setGenero(request.getParameter("txtGenero"));
		oModelPaciente.setTipoSangre(request.getParameter("txtTipoSangre"));
		oModelPaciente.setEsterilizado(request.getParameter("txtEsterilizado"));
		oModelPaciente.setTamano(request.getParameter("txtTamano"));
		oModelPaciente.setActividad(request.getParameter("txtActividad"));
		oModelPaciente.setPeso(request.getParameter("txtPeso"));
		oModelPaciente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
		
		try {
			Paciente.GrabarModificarProspecto(oModelPaciente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}
	
	@RequestMapping(value = "/eliminarPaciente", method = RequestMethod.GET)
	public ModelAndView eliminarPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarPaciente");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigoDueno(request.getParameter("txtCodigoDueno"));
		oModelPaciente.setCodigoPaciente(request.getParameter("txtCodigoPaciente"));
		oModelPaciente.setEspecie(request.getParameter("txtEspecie"));
		oModelPaciente.setRaza(request.getParameter("txtRaza"));
		oModelPaciente.setGenero(request.getParameter("txtGenero"));
		oModelPaciente.setTipoSangre(request.getParameter("txtTipoSangre"));
		oModelPaciente.setEsterilizado(request.getParameter("txtEsterilizado"));
		oModelPaciente.setTamano(request.getParameter("txtTamano"));
		oModelPaciente.setActividad(request.getParameter("txtActividad"));
		oModelPaciente.setPeso(request.getParameter("txtPeso"));
		oModelPaciente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
		
		try {
			Paciente.deleteprospecto(oModelPaciente.getCodigo());
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
	
	@RequestMapping(value = "/CambiarPaciente", method = RequestMethod.GET)
	public ModelAndView CambiarPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("CambiarPaciente");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigo(request.getParameter("id"));
		
		try {
			Paciente.changeProspectoToPaciente(oModelPaciente.getCodigo());
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente.jsp");
	}

	@RequestMapping(value="/listarcliente2.jsp")
	public ModelAndView ListarPacientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Paciente> pacientes = this.Paciente.listPacientes();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("pacientes",pacientes);
		
        return new ModelAndView("listarclienteC", "model", myModel);
        
    }
	
	@RequestMapping(value = "/eliminarPacienteC", method = RequestMethod.GET)
	public ModelAndView eliminarPacienteC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarPacienteC");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigo(request.getParameter("id"));
	
		try {
			Paciente.deleteprospecto(oModelPaciente.getCodigo());
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente2.jsp");
	}
	
	
	@RequestMapping(value = "/editarPacienteC", method = RequestMethod.GET)
	public ModelAndView editarPacienteC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Paciente oModelPaciente = new Paciente();
		oModelPaciente = Paciente.ObtenerProspecto(request.getParameter("id"));
		
		System.out.println("idPaciente "+request.getParameter("id"));
		return new ModelAndView("editarPacienteC", "model", oModelPaciente);
	}
	
	@RequestMapping(value = "/guardarModificacionPacienteC", method = RequestMethod.POST)
	public ModelAndView modificarPacienteC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("guardarModificacionPacienteC");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigoDueno(request.getParameter("txtCodigoDueno"));
		oModelPaciente.setCodigoPaciente(request.getParameter("txtCodigoPaciente"));
		oModelPaciente.setEspecie(request.getParameter("txtEspecie"));
		oModelPaciente.setRaza(request.getParameter("txtRaza"));
		oModelPaciente.setGenero(request.getParameter("txtGenero"));
		oModelPaciente.setTipoSangre(request.getParameter("txtTipoSangre"));
		oModelPaciente.setEsterilizado(request.getParameter("txtEsterilizado"));
		oModelPaciente.setTamano(request.getParameter("txtTamano"));
		oModelPaciente.setActividad(request.getParameter("txtActividad"));
		oModelPaciente.setPeso(request.getParameter("txtPeso"));
		oModelPaciente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
		
		try {
			Paciente.GrabarModificarProspecto(oModelPaciente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarcliente2.jsp");
	}
}
