package com.cursospring.restApiProject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.restApiProject.model.BeanFiltradoEstatico;

@RestController
public class FiltradoEstaticoController {

	@GetMapping("/filtrado-estatico")
	public BeanFiltradoEstatico devuelveFiltradoEstatico() {
		return new BeanFiltradoEstatico("Alberto","Contrasena123",42,"Fuente del tiro","Madrid");
	}
	
	@GetMapping("/filtrado-estatico-lista")
	public List<BeanFiltradoEstatico> devuelveFiltradoEstaticoLista() { //Los Ignore aplican a todos los objetos de la lista
		return Arrays.asList(new BeanFiltradoEstatico("Alberto", "Contrasena123", 42, "Fuente del tiro", "Madrid"),
				new BeanFiltradoEstatico("Laura", "Contrasena234", 46, "Fuente del tiro", "Madrid"));
	}
}
