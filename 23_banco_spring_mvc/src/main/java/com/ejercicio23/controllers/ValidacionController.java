package com.ejercicio23.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.service.GestionCajero;

@Controller
public class ValidacionController {
	
	@Autowired
	GestionCajero gcajero;
	
	@RequestMapping("/doValidacion")
	public String login(@RequestParam("codigoCuenta") int codigoCuenta,HttpSession session){
		gcajero.autenticarCuenta(codigoCuenta);
		session.setAttribute("codigoCuenta", codigoCuenta);
		return "operaciones";
	}
}
