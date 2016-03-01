package com.ejercicio19.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.service.GestionCuentasService;


@Controller
public class LoginController {
	
	@Autowired
	GestionCuentasService gservice;
	@RequestMapping("/doValidar")
	public String login(@RequestParam("codigo") int codigo, 
						 HttpSession sesion){	
		if(gservice.obtenerCuenta(codigo)!=null){
			sesion.setAttribute("codigo", codigo);
			return "operaciones";
		}else{
			return "inicio";
		}
	}

}
