package com.ejercicio23.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/toIngreso")
	public String ingreso(){
		return "ingreso";
	}
	
	@RequestMapping({"/toExtraccion"})
	public String extraccion(){
		return "extraccion";
	}
	
	@RequestMapping({"/toOperaciones"})
	public String operaciones(){
		return "operaciones";
	}
	
	@RequestMapping({"/"})
	public String inicio(){
		return "inicio";
	}
}


