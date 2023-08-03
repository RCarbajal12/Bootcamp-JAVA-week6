package com.romina.leanguage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romina.leanguage.models.LanguageModel;
import com.romina.leanguage.services.LanguageService;

@RestController
public class LanguageApiController {
	
	@Autowired
	private LanguageService languageservice;
	
    //MOSTRAR INFORMACIÓN DE TODOS LOS LENGUAJES
    @GetMapping("/api/languages")
    public List<LanguageModel> index() {
        return languageservice.allLanguages();
    }
    
	//CREAR UN LENGUAJE
    @PostMapping(value="/api/languages")
    public LanguageModel create(@RequestParam(value="language") String name, 
    		@RequestParam(value="create") String create, 
    		@RequestParam(value="numberOfVersion") String numberOfVersion) {
        LanguageModel language = new LanguageModel(name, create, numberOfVersion);
        return languageservice.createLanguages(language);
    }
    
    //MOSTRAR INFORMACION DE UN LENGUAJE ESPECIFICO
    @GetMapping("/api/languages/{id}")
    public LanguageModel show(@PathVariable("id") Long id) {
        LanguageModel language = languageservice.findLanguage(id);
        return language;
    }
    
    //ACTUALIZAR INFORMACION DE UN LENGUAJE ESPECIFICO
    @PutMapping("/api/languages/{id}")
    public LanguageModel actualizar(@PathVariable("id")Long id,
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="create") String create,
    		@RequestParam(value="numberOfVersion") String numberOfVersion) {
    	LanguageModel language = new LanguageModel(id, name, create, numberOfVersion);
        return languageservice.updateLanguage(language);
    	//return bookService.actualizarLibro(id, title, desc, lang,numOfPages );
    }

    //BORRAR LENGUAJE
    @DeleteMapping("/api/languages/{id}")
    public void borrarRegistro(@PathVariable("id")Long id) {
    	languageservice.borrarLanguage(id);
    }
}
