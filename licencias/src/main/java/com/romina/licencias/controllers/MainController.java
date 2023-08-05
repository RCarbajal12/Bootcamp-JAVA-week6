package com.romina.licencias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.romina.licencias.models.Licencia;
import com.romina.licencias.models.Persona;
import com.romina.licencias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	// INYECCION DEPENDENCIAS 
	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String root(Model viewModel) {
		
		List<Persona> todosUsuarios = mainService.todasPersonas();
		viewModel.addAttribute("todos", todosUsuarios);
		return "index.jsp";
	}

	@GetMapping("/persons/new")
	public String formularioPersona(@ModelAttribute("persona") Persona persona) {
		return "newperson.jsp";
	}

	@PostMapping("/persons/new")
	public String crearPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult resultado) {
		if (resultado.hasErrors()) {

			return "newperson.jsp";
		}
		mainService.crearPersona(persona);
		return "redirect:/";

	}

	@GetMapping("/licencias/new")
	public String formularioLicencia(@ModelAttribute("licencia") Licencia licencia, Model viewModel) {
//		List<Persona> todosUsuarios = mainService.todasPersonas();
//		viewModel.addAttribute("personas", todosUsuarios);
		viewModel.addAttribute("personas", mainService.obtenerPersonasSinLic());
		return "newlic.jsp";
	}

	@PostMapping("licencias/new")
	public String crearLicencia(@Valid @ModelAttribute("licencia") Licencia licencia, 
			BindingResult resultado, Model viewModel) {
		if (resultado.hasErrors()) {
//			viewModel.addAttribute("personas", mainService.todasPersonas());
			viewModel.addAttribute("personas", mainService.obtenerPersonasSinLic());
			return "newlic.jsp";
		}
		mainService.crearLicencia(licencia);

		return "redirect:/";
	}
	
//	@GetMapping("/licencias/{id}")
//	public String details(@PathVariable("id") Long id, Model model) {
//		Licencia licencia = mainService.findInfo(id);
//		model.addAttribute("Licencia", licencia);
//		return "showinfo.jsp";
//	}
	
//	@GetMapping("/licencias/{id}")
//	public String details(@PathVariable("id") Long id, Model model) {
//	    Licencia licencia = mainService.findInfo(id);
//	    System.out.println("Licencia encontrada: " + licencia); // Verificar si se encuentra la licencia
//	    model.addAttribute("Licencia", licencia);
//	    return "showinfo.jsp";
//	}
	
//	@GetMapping("/licencias/{id}")
//	public String details(Model viewModel) {
//		
//		List<Persona> todosUsuarios = mainService.todasPersonas();
//		viewModel.addAttribute("todos", todosUsuarios);
//		return "showinfo.jsp";
//	}


//	@GetMapping("/licencias/{id}")
//	public String mostrarPersona(@PathVariable("id") Long id, Model viewModel) {
//	    Persona personaBuscada = mainService.buscarPersonaPorId(id);
//	    
//	    if (personaBuscada != null) {
//	        viewModel.addAttribute("personaBuscada", personaBuscada);
//	    } else {
//	        viewModel.addAttribute("mensajeError", "Persona no encontrada");
//	    }
//	    
//	    return "showinfo.jsp";
//	}
	
	
	@GetMapping("/licencias/{id}")
	public String mostrarPersona(@PathVariable("id") Long id, Model viewModel) {
	    Persona personaBuscada = mainService.buscarPersonaPorId(id);
	    
	    if (personaBuscada != null) {
	        viewModel.addAttribute("personaBuscada", personaBuscada);
	    } else {
	        viewModel.addAttribute("mensajeError", "Persona no encontrada");
	    }
	    
	    return "showinfo.jsp";
	}



}