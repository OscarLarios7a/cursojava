package com.ejercicio19.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entidades.Movimiento;
import modelo.service.GestionCuentasService;

@Controller
public class MovimientosController {
	@Autowired
	GestionCuentasService gservice;
	@RequestMapping("/doMovimientos")
	public String recuperar(HttpSession sesion, HttpServletRequest request){
		int codigo=(Integer)sesion.getAttribute("codigo");
		List<Movimiento> movs=gservice.obtenerMovimientos(codigo);
		request.setAttribute("movimientos", movs);
		request.setAttribute("saldo", gservice.obtenerSaldo(codigo));
		return "movimientos";
	}
}
