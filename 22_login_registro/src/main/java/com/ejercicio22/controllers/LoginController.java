package com.ejercicio22.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Libro;
import modelo.GestionClientes;
import modelo.GestionLibros;

@Controller
public class LoginController {

	@Autowired
	GestionClientes gclientes;
	@Autowired
	GestionLibros glibros;
	
	@RequestMapping("/doLogin")
	public String login(@RequestParam("usuario") String user,
				        @RequestParam("password") String pwd, HttpServletRequest request){
		if(gclientes.estaRegistrado(user, pwd)){
			List<Libro> libros = glibros.recuperarLibros();
			request.setAttribute("libros", libros);
			return "listado";
		}else{
			return "error";
		}
	}
}
