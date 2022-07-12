package com.CRUDEXAMPLE.demo.interfaceServices;

import com.CRUDEXAMPLE.demo.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterfazPersonaService {
     public List<Persona> listar();
     public Optional<Persona> listarId(int id);
     public int save(Persona p);
     public void delete(int id);
}
