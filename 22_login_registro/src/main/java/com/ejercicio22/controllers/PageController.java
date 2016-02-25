package com.ejercicio22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/toRegistro")
	public String registrese(){
		return "registro";
	}
	
	@RequestMapping({"/toLogin","/"})
	public String inicio(){
		return "login";
	}
}
