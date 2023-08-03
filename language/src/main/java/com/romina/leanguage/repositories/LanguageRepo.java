package com.romina.leanguage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.romina.leanguage.models.LanguageModel;

public interface LanguageRepo extends CrudRepository<LanguageModel, Long>{
	
	 //ESTE MÉTODO RECUPERA TODOS LOS LENGUAJES DE LA BASE DE DATOS
    List<LanguageModel> findAll();
    
    //ESTE MÉTODO ENCUENTRA UN LENGUAJE POR SU DESCRIPCIÓN
    //List<LanguageModel> findByDescriptionContaining(String search);
    
    //ESTE MÉTODO CUENTA CUÁNTOS LIBROS CONTIENE CIERTA CADENA EN EL TÍTULO
    //Long countByTitleContaining(String search);
    
    //ESTE MÉTODO BORRA UN LIBRO QUE EMPIEZA CON UN TÍTULO ESPECÍFICO
   // Long deleteByTitleStartingWith(String search);

}
