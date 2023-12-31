package com.romina.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.romina.dojosyninjas.models.NinjaModel;
import com.romina.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	//INYECCION DEPENDENCIAS
	private final MainService mainServ;
	public NinjaController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/ninja/new")
	public String formNinja(@ModelAttribute("ninjaform") NinjaModel ninja, Model viewModel) {
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return "/ninjas/nuevoninja.jsp";
	}
	
	
	@PostMapping("/ninja/new")
	public String nuevoNinja(@Valid @ModelAttribute("ninjaform") NinjaModel ninja, 
			BindingResult resultado, Model viewModel) {
		if(resultado.hasErrors()) {
			System.out.println(ninja.getAge()+ " MENSAJE IMPORTANTE "+ resultado.getFieldErrors());
			viewModel.addAttribute("dojos", mainServ.todosDojos());
			return "/ninjas/nuevoninja.jsp";
		}
		mainServ.crearNinja(ninja);
		return "redirect:/dojos";
		
		
	}

}