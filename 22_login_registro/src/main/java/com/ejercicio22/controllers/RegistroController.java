package com.ejercicio22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Cliente;
import modelo.GestionClientes;

@Controller
public class RegistroController {
	
	@Autowired
	GestionClientes gclientes;
	
	@RequestMapping("/doRegistro")
	public String registrar(@RequestParam("usuario") String user,
							@RequestParam("password") String pwd, 
							@RequestParam("email") String email,
						 	@RequestParam("telefono") int tel){
		Cliente cliente = new Cliente(0, user, pwd, email, tel);
		gclientes.registrarCliente(cliente);
		return "login";
	}
}
