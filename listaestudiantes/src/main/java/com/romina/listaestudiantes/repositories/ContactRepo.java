package com.romina.listaestudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romina.listaestudiantes.models.ContactModel;

@Repository
public interface ContactRepo extends CrudRepository<ContactModel, Long>{
	
	

}
