package com.cursospring.restApiProject.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursospring.restApiProject.model.BeanFiltradoDinamico;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

//El filtrado dinámico aplica en función de la petición que se realice.
@RestController
public class FiltradoDinamicoController {

	@GetMapping("/filtrado-dinamico") 
	public MappingJacksonValue devuelveFiltradoDinamico() {
		
		//Creamos un objeto del bean que queremos filtrar
		BeanFiltradoDinamico beanFiltradoDinamico = new BeanFiltradoDinamico("Alberto","Contrasena123",42,"Fuente del tiro","Madrid");
		//Creamos un objeto MappingJacksonValue para poder filtrar el bean
		return aplicarFiltro(beanFiltradoDinamico, "NombreDelFiltro", "nombre","edad");
	}

	@GetMapping("/filtrado-dinamico-lista") 
	public MappingJacksonValue devuelveFiltradoDinamicoLista() {
		
		List<BeanFiltradoDinamico> lista = Arrays.asList(
				new BeanFiltradoDinamico("Alberto","Contrasena123",42,"Fuente del tiro","Madrid"),
				new BeanFiltradoDinamico("Laura", "Contrasena234", 46, "Fuente del tiro", "Madrid") );
		//Creamos un objeto MappingJacksonValue para poder filtrar el bean
		return aplicarFiltro(lista, "NombreDelFiltro", "nombre","direccion");
	}
	
	private MappingJacksonValue aplicarFiltro(Object objeto, String nombreFiltro, String... propiedades) {
        //Creamos un objeto MappingJacksonValue para poder filtrar el objeto/lista
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(objeto);
        //Creamos un filtro para filtrar las propiedades que queremos. Se podría filtrar una a una o varias a la vez, o, como en este caso, todas excepto las que queramos enviar.
        SimpleBeanPropertyFilter filtro = SimpleBeanPropertyFilter.filterOutAllExcept(propiedades);
        //Creamos un objeto FilterProvider para poder aplicar el filtro al objeto MappingJacksonValue
        FilterProvider filtros = new SimpleFilterProvider().addFilter(nombreFiltro, filtro);
        //Aplicamos el filtro al objeto MappingJacksonValue
        mappingJacksonValue.setFilters(filtros);
        //Devolvemos el objeto MappingJacksonValue con el filtro aplicado
        return mappingJacksonValue;
    }
}
