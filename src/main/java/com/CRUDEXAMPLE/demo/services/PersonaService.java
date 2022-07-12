package com.CRUDEXAMPLE.demo.services;

import com.CRUDEXAMPLE.demo.interfaceServices.InterfazPersonaService;
import com.CRUDEXAMPLE.demo.interfaces.PersonaInterface;
import com.CRUDEXAMPLE.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements InterfazPersonaService {
    @Autowired
    private PersonaInterface dataPersona;
    @Override
    public List<Persona> listar() {
        return (List<Persona>) dataPersona.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return Optional.of(dataPersona.findById(id).get());
    }

    @Override
    public int save(Persona p) {
        int respuesta=0;
        Persona persona = dataPersona.save(p);
        if(persona != null){
            respuesta=1;
        }else {
            respuesta=0;
        }
        return 0;
    }

    @Override
    public void delete(int id) {
    dataPersona.deleteById(id);
    }
}
