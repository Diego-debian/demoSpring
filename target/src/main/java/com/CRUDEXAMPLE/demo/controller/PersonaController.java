package com.CRUDEXAMPLE.demo.controller;

import com.CRUDEXAMPLE.demo.interfaceServices.InterfazPersonaService;
import com.CRUDEXAMPLE.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class PersonaController {
    @Autowired
    private InterfazPersonaService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "form";
    }
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String save(@ModelAttribute("persona") Persona p){
        service.save(p);
        return "redirect:/listar";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editarFormulario(@PathVariable(name = "id") int id){
    ModelAndView modelAndView = new ModelAndView("editarForm");
    Optional<Persona> persona = service.listarId(id);
    modelAndView.addObject("persona", persona);
    return modelAndView;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarFormulario(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/listar";
    }
}
