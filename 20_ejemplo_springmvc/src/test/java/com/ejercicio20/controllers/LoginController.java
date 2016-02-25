package com.ejercicio20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(@RequestParam("usuario") String user, @RequestParam("password") String pwd){
		if(pwd.equals("cursojava")){
			return "entrada";
		}else{
			return "error";
		}
	}
	
}
