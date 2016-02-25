package com.ejercicio23.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.service.GestionCajero;

@Controller
public class IngresoController {
	
	@Autowired
	GestionCajero gcajero;
	
	@RequestMapping("/doIngresar")
	public String ingresar(@RequestParam("cantidad") double cantidad,HttpSession session){
		int cuenta = (Integer) session.getAttribute("codigoCuenta");
		gcajero.ingresar(cuenta, cantidad);
		return "operaciones";
	}	
	
}
