package com.proyecto.control.escolar.controlescolar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.control.escolar.controlescolar.service.LoginService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping("/token")
	public void createToken() { 
		loginService.encryptPassword("Pr3fieroElsushifrio.-");
	}
}
