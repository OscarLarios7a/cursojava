package com.ejercicio19.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.service.GestionCuentasService;


@Controller
public class ExtraerController {
	@Autowired
	GestionCuentasService gservice;
	@RequestMapping("/doExtraer")
	public String ingresar(@RequestParam("cantidad") double cantidad, 
						 HttpSession session){
		int codigo=(Integer)session.getAttribute("codigo");
		gservice.extraer(codigo, cantidad);
		return "operaciones";	
		
	}
}
