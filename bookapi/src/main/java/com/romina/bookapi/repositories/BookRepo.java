package com.romina.bookapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romina.bookapi.models.BookModel;

@Repository
public interface BookRepo extends CrudRepository<BookModel, Long>{
	

	    //ESTE MÉTODO RECUPERA TODOS LOS LIBROS DE LA BASE DE DATOS
	    List<BookModel> findAll();
	    
	    //ESTE MÉTODO ENCUENTRA UN LIBRO POR SU DESCRIPCIÓN
	    List<BookModel> findByDescriptionContaining(String search);
	    
	    //ESTE MÉTODO CUENTA CUÁNTOS LIBROS CONTIENE CIERTA CADENA EN EL TÍTULO
	    Long countByTitleContaining(String search);
	    
	    //ESTE MÉTODO BORRA UN LIBRO QUE EMPIEZA CON UN TÍTULO ESPECÍFICO
	    Long deleteByTitleStartingWith(String search);
	
	

}
