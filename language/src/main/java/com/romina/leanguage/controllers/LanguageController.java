package com.romina.leanguage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.romina.leanguage.models.LanguageModel;
import com.romina.leanguage.services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageservice;
	
    @GetMapping("/")
    public String raiz() {
    	return "redirect:/languages";
    }
    
    //TODOS LOS LENGUAJES
    @GetMapping("/languages")
    public String index(Model model) {
        List<LanguageModel> languages = languageservice.allLanguages();
        model.addAttribute("languages", languages);
        return "languages/index.jsp";
    }
    
    //NUEVO LENGUAJE
//    @GetMapping("/languages/new")
//    public String nuevoLenguage(@ModelAttribute("language")LanguageModel language) {
//    	return "languages/index.jsp";
//    }
    //CREAR LENGUAJE
//    @PostMapping("/languages")
//    public String create(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result, Model viewMode) {
//        if (result.hasErrors()) {
//            return "languages/index.jsp";
//        } else {
//            languageservice.createLanguages(language);
//            return "redirect:/languages";
//        }
//    }
    
    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<LanguageModel> languages = languageservice.allLanguages();
            model.addAttribute("languages", languages);
            return "languages/index.jsp";
        } else {
            languageservice.createLanguages(language);
            return "redirect:/languages";
        }
    }
    
    //INFORMACION DE UN LIBRO EN ESPECÍFICO
    @GetMapping("/languages/{id}")
    public String show(@PathVariable Long id, Model model) {
        LanguageModel language = languageservice.findLanguage(id);

        if (language != null) {
            model.addAttribute("language", language);
            return "languages/show.jsp";
        } else {
            return "redirect:/languages";
        }
    }
    
    //EDITAR UN LENGUAJE
    @GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	LanguageModel language = languageservice.findLanguage(id);
    	model.addAttribute("language", language);
    	return "languages/edit.jsp";
    }
    
    @PutMapping(value="/languages/{id}")
    public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
    	if (result.hasErrors()) {
    		return "/languages/edit.jsp";
    	} else {
    		languageservice.updateLanguage(language);
    		return "redirect:/languages";
    	}
    }
    
    //BORRAR UN LENGUAJE
    @DeleteMapping(value="/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
        languageservice.borrarLanguage(id);
        return "redirect:/languages";
    }
    
}
