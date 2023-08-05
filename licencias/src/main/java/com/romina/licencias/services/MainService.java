package com.romina.licencias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romina.licencias.models.Licencia;
import com.romina.licencias.models.Persona;
import com.romina.licencias.repositories.LicenciaRepo;
import com.romina.licencias.repositories.PersonaRepo;

@Service
public class MainService {
	
	//INYECCIÓN DEPENDENCIAS
	@Autowired
	private LicenciaRepo licenciaRepo;
	
	@Autowired 
	private PersonaRepo personaRepo;
	
	
	//SERVICIOS PARA PERSONA
	public Persona crearPersona(Persona persona) {
		return personaRepo.save(persona);
	}
	
	public List<Persona> todasPersonas(){
		return personaRepo.findAll();
	}
	
	
	//SERVICIOS PARA LICENCIA
	public Licencia crearLicencia(Licencia licencia) {
		licencia.setNumber(this.generarNumerLic());
		return licenciaRepo.save(licencia);
	}
	
	public List<Persona> obtenerPersonasSinLic(){
		return personaRepo.findByLicenciaIdIsNull();
//		return personaRepo.encontrarNoLic();
	}
	
	
	//MÉTODO PARA GENERAR NÚMERO DE LICENCIA
	public int generarNumerLic() {
		Licencia lic = licenciaRepo.findTopByOrderByNumberDesc();
		if(lic ==null) {
			return 1;
		}
		int numeroMayorLicencia = lic.getNumber();
		numeroMayorLicencia++;
		return numeroMayorLicencia;
		
	}

	//MÉTODO PARA VER INFORMACION ESPECIFICA
//	public Licencia findInfo(Long id) {
//		Optional<Licencia> optionalSong = licenciaRepo.findById(id);
//		if(optionalSong.isPresent()) {
//			return optionalSong.get();
//		}else {
//			return null;
//		}
//	}
	
//	public Persona buscarPersonaPorId(Long id) {
//	    Optional<Persona> optionalPersona = personaRepo.findById(id);
//	    return optionalPersona.orElse(null);
//	}
//	
    public Persona buscarPersonaPorId(Long id) {
        Optional<Persona> optionalPersona = personaRepo.findById(id);
        return optionalPersona.orElse(null);
    }
}