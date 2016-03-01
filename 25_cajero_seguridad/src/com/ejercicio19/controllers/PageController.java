package com.ejercicio19.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/toIngresar")
	public String ingresar(){
		return "ingresar";
	}
	@RequestMapping("/toExtraer")
	public String extraer(){
		return "extraer";
	}
	@RequestMapping("/")
	public String inicio(){
		return "inicio";
	}
	@RequestMapping("/toOperaciones")
	public String operaciones(){
		return "operaciones";
	}
	
	
	
}
