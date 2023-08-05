package com.romina.licencias.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romina.licencias.models.Licencia;

@Repository
public interface LicenciaRepo extends CrudRepository<Licencia, Long>{

	public Licencia findTopByOrderByNumberDesc();
	
}