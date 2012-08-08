package net.furious.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vetfurious.negocio.ILogin;

import net.vetfurious.modelo.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@Autowired
	private ILogin iLogin;

	@RequestMapping(value = "/editarLogin", method = RequestMethod.POST)
	public ModelAndView j_spring_security_check(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException, Exception {
		Login oModelLogin = new Login();
		oModelLogin.setUsuario(request.getParameter("Usuario"));
		oModelLogin.setPassword(request.getParameter("Password"));
		
		oModelLogin = iLogin.ObtenerCredenciales(oModelLogin);
	
		return new ModelAndView("editarLogin", "model", oModelLogin);
	}
	
	@ExceptionHandler(Exception.class)	
	public ModelAndView Exception(Exception e , HttpServletRequest request){		
		return new ModelAndView("/error", "mensaje", e.getMessage());	
	}
}
