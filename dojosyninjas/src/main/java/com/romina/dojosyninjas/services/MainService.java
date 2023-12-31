package com.romina.dojosyninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.romina.dojosyninjas.models.DojoModel;
import com.romina.dojosyninjas.models.NinjaModel;
import com.romina.dojosyninjas.repositories.DojoRepo;
import com.romina.dojosyninjas.repositories.NinjaRepo;

@Service
public class MainService {
	
	//INYECCION DEPENDENCIAS
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	public MainService(DojoRepo dojoR, NinjaRepo ninjaR ) {
		this.dojoRepo = dojoR;
		this.ninjaRepo = ninjaR;
	}
	
	
	//METODOS CREATE
	public DojoModel crearDojo(DojoModel dojo) {
		return dojoRepo.save(dojo);
	}
	public NinjaModel crearNinja(NinjaModel ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
	//METODOS LEER
	public List<DojoModel> todosDojos(){
		return dojoRepo.findAll();
	}
	public List<NinjaModel> todosNinjas(){
		return ninjaRepo.findAll();
	}
	
	public DojoModel unDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
		
	}
	
	

}