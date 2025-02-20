package com.cursospring.ejercicio14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ejercicio14Application {
  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(com.cursospring.ejercicio14.Ejercicio14Application.class, args);
    Perro perro = (Perro)applicationContext.getBean("can");
    perro.setName("Perraco");
    System.out.println(perro);
  }
}