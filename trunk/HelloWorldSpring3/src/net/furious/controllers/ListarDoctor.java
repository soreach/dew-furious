package net.furious.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.vetfurious.negocio.IDoctor;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ListarDoctor {
		
		@Autowired
		private IDoctor Doctor;
		
		@RequestMapping(value="/listardoctor.jsp")
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, DAOExcepcion {
			
			
			List<Doctor> personas = this.Doctor.listDoctores();
			
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("personas",personas);
	       
	        return new ModelAndView("listardoctor", "model", myModel);

	    }
		
		@RequestMapping(value = "/verRegistroDoctor", method = RequestMethod.GET)
		public ModelAndView ingresar(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			return new ModelAndView("nuevoDoctor");
		}
		/*
		@RequestMapping(value = "/registrarDoctor", method = RequestMethod.POST)
		public ModelAndView registroDoctor(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("registrarDoctor");
			
			Persona oModelPersona = new Persona();
			oModelPersona.setId(Integer.parseInt(request.getParameter("id")));
			oModelPersona.setNombre(request.getParameter("txtNombre"));
			oModelPersona.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
			oModelPersona.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
			oModelPersona.setRaza(request.getParameter("txtRaza"));
			
			try {
				Persona.insertarPersona(oModelPersona);
			} catch (Exception e) {
				return new ModelAndView("/error", "mensaje", e.getMessage());
			}

			return new ModelAndView("redirect:listardoctor.jsp");
		}
		
		@RequestMapping(value = "/editarDoctor", method = RequestMethod.GET)
		public ModelAndView editar(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			Persona oModelPersona = new Persona();
			oModelPersona = Persona.obtenerPorIdPersona(Integer.parseInt(request.getParameter("id")));
			
			System.out.println("idPersona "+request.getParameter("id"));
			return new ModelAndView("editarDoctor", "model", oModelPersona);
		}
		
		@RequestMapping(value = "/guardarModificacionDoctor", method = RequestMethod.POST)
		public ModelAndView modificarDoctor(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("registarDoctor");
			
			Persona oModelPersona = new Persona();
			oModelPersona.setId(Integer.parseInt(request.getParameter("id")));
			oModelPersona.setNombre(request.getParameter("txtNombre"));
			oModelPersona.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
			oModelPersona.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
			oModelPersona.setRaza(request.getParameter("txtRaza"));
			
			try {
				Persona.modificarPersona(oModelPersona);
			} catch (Exception e) {
				return new ModelAndView("/error", "mensaje", e.getMessage());
			}

			return new ModelAndView("redirect:listardoctor.jsp");
		}
		
		@RequestMapping(value = "/eliminarDoctor", method = RequestMethod.GET)
		public ModelAndView eliminarDoctor(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("eliminarDoctor");
			
			Persona oModelPersona = new Persona();
			oModelPersona.setId(Integer.parseInt(request.getParameter("id")));
			oModelPersona.setNombre(request.getParameter("txtNombre"));
			oModelPersona.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
			oModelPersona.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
			oModelPersona.setRaza(request.getParameter("txtRaza"));
			
			try {
				Persona.eliminarPersona(oModelPersona);
			} catch (Exception e) {
				return new ModelAndView("/error", "mensaje", e.getMessage());
			}

			return new ModelAndView("redirect:listardoctor.jsp");
		}

	*/

}
