package com.ejercicio23.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entidades.Movimiento;
import modelo.service.GestionCajero;

@Controller
public class MovimientoController {
	
	@Autowired
	GestionCajero gcajero;
	
	@RequestMapping("/doMovimientos")
	public String obtenerMovimientos(HttpSession session,HttpServletRequest request){
		int cuenta = (Integer) session.getAttribute("codigoCuenta");
		List<Movimiento> movimientos = gcajero.obtenerMovimientos(cuenta);
		double saldo = gcajero.obtenerSaldo(cuenta);		
		request.setAttribute("movimientos", movimientos);
		request.setAttribute("saldo", saldo);
		return "movimientos";
	}
}
