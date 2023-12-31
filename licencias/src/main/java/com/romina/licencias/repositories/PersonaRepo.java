package com.romina.licencias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romina.licencias.models.Persona;

@Repository
public interface PersonaRepo extends CrudRepository<Persona, Long> {
	
	List<Persona> findAll();
	
	
	@Query(value="SELECT p.* FROM persona p LEFT OUTER JOIN licencia l ON p.id=l.persona_id WHERE l.id IS NULL", nativeQuery=true)
	List<Persona> encontrarNoLic();
	
	List<Persona> findByLicenciaIdIsNull();
	
	Optional<Persona> findById(Long id);
	
	

}
