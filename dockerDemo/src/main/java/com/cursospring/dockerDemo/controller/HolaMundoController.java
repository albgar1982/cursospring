package com.cursospring.dockerDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

	@GetMapping("/")
	public String holaMundo() {
		return "{\"mensaje\":\"Hola mundo v4\"}";
	}
}
