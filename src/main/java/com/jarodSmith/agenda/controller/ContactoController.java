package com.jarodSmith.agenda.controller;

import com.jarodSmith.agenda.model.Contacto;
import com.jarodSmith.agenda.repo.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
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

        return new ModelAndView("form")
                .addObject("contacto", new Contacto());
    }

    @PostMapping("/nuevo")
    ModelAndView crear(@Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes ra){

        if(bindingResult.hasErrors()){
            return new ModelAndView("form")
                    .addObject("contacto", contacto);
        }
        contactoRepository.save(contacto);
        ra.addFlashAttribute("msgExito", "¡El Contacto ha sido registrado correctamente!");

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/{id}/editar")
    ModelAndView editar(@PathVariable Integer id){

        Contacto contacto = contactoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return new ModelAndView("form")
                .addObject("contacto", contacto);
    }

    @PostMapping("/{id}/editar")
    ModelAndView actualizar(@PathVariable Integer id,
                            @Validated Contacto contacto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){

        contactoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        if(bindingResult.hasErrors()){
            return new ModelAndView("form")
                    .addObject("contacto", contacto);
        }

        contacto.setId(id);
        contactoRepository.save(contacto);

        redirectAttributes.addFlashAttribute("msgExito", "¡El contacto fue actualizado correctamente!");
        return new ModelAndView("redirect:/");
    }
}
