package com.cursospring.ejercicio14;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component("can")
@Setter
@Slf4j
public class Perro {

  private String name;
  
  private byte edad;
  
  public String toString() {
    log.info("Se llama a su toString() desde la clase Perro.");
    return "Perro [name=" + this.name + ", edad=" + this.edad + "]";
  }
}
