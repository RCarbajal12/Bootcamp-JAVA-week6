package com.romina.listaestudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romina.listaestudiantes.models.EstudianteModel;

@Repository
public interface EstudianteRepo extends CrudRepository<EstudianteModel, Long> {
	
	List<EstudianteModel> findAll();
	
	List<EstudianteModel> findByContactmodelIsNull();
	
	Optional<EstudianteModel> findById(Long id);

}
