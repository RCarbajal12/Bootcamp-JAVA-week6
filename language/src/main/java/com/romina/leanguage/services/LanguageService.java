package com.romina.leanguage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romina.leanguage.models.LanguageModel;
import com.romina.leanguage.repositories.LanguageRepo;


@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepo languagerepo;
	
    //DEVOLVIENDO TODOS LOS LENGUAJES
    public List<LanguageModel> allLanguages() {
        return languagerepo.findAll();
    }
    
    //CREANDO UN LENGUAJE
    public LanguageModel createLanguages(LanguageModel b) {
        return languagerepo.save(b);
    }
    
    //OBTENIENDO LOS DETALLES DE UN LENGUAJE EN ESPECÍFICO
    public LanguageModel findLanguage(Long id) {
        Optional<LanguageModel> optionalLanguage = languagerepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
  //ACTUALIZAR INFORMACION
    public LanguageModel updateLanguage(LanguageModel language) {
    	LanguageModel temporal = findLanguage(language.getId());
    	temporal.setName(language.getName());
    	temporal.setCreator(language.getCreator());
    	temporal.setNumberOfVersion(language.getNumberOfVersion());
    	
    	return languagerepo.save(temporal);
    }
    //SOBRECARGA DE METODO DE ACTUALIZAR INFORMACION
	public LanguageModel updateLanguage(Long id,
			String name, 
			String creator, 
			String numberOfVersion) {
		LanguageModel temporal = languagerepo.findById(id).orElse(null);
		if(temporal != null) {
			temporal.setName(name);
			temporal.setCreator(creator);
			temporal.setNumberOfVersion(numberOfVersion);
			
			languagerepo.save(temporal);
			return temporal;
		}else {
			return temporal;
		}
	}
	
	//BORRAR UN LENGUAJE
	public void borrarLanguage(Long id) {
		languagerepo.deleteById(id);
	}


}
