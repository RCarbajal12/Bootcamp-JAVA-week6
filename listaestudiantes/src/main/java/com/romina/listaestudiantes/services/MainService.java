package com.romina.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romina.listaestudiantes.models.ContactModel;
import com.romina.listaestudiantes.models.EstudianteModel;
import com.romina.listaestudiantes.repositories.ContactRepo;
import com.romina.listaestudiantes.repositories.EstudianteRepo;


@Service
public class MainService {
	
		//INYECCIÓN DEPENDENCIAS
		@Autowired
		private EstudianteRepo estudianteRepo;
		
		@Autowired 
		private ContactRepo contactRepo;
		
		
		//SERVICIOS PARA PERSONA
		public EstudianteModel crearEstudiante(EstudianteModel estudiante) {
			return estudianteRepo.save(estudiante);
		}
		
		public List<EstudianteModel> todosEstudiantes(){
			return estudianteRepo.findAll();
		}
		

		//SERVICIOS PARA LICENCIA
		public ContactModel crearContacto(ContactModel contact) {
			return contactRepo.save(contact);
		}
		
		public List<EstudianteModel> obtenerEstudianteSinContacto(){
			return estudianteRepo.findByContactmodelIsNull();
		}
		
	    public EstudianteModel buscarEstudiantePorId(Long id) {
	        Optional<EstudianteModel> optionalEstudiante = estudianteRepo.findById(id);
	        return optionalEstudiante.orElse(null);
	    }
}
