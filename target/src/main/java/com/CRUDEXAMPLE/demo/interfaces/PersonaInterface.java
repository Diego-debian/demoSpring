package com.CRUDEXAMPLE.demo.interfaces;

import com.CRUDEXAMPLE.demo.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaInterface extends CrudRepository<Persona, Integer> {
}
