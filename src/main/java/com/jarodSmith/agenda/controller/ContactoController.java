package com.jarodSmith.agenda.controller;

import com.jarodSmith.agenda.model.Contacto;
import com.jarodSmith.agenda.repo.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactoController {
    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping("")
    ModelAndView index(){
        List<Contacto> contactos = contactoRepository.findAll();
        return new ModelAndView("index")
                .addObject("contactos", contactos);
    }

    @GetMapping("/nuevo")
    ModelAndView nuevo(){
        return new ModelAndView("nuevo")
                .addObject("contacto", new Contacto());
    }

    @PostMapping("/nuevo")
    String crear(Contacto contacto, RedirectAttributes ra){
        contactoRepository.save(contacto);
        ra.addFlashAttribute("msgExito", "¡El Contacto ha sido registrado correctamente!");
        return "redirect:/";
    }

}
