package com.romina.dojosyninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.romina.dojosyninjas.models.DojoModel;

public interface DojoRepo extends CrudRepository<DojoModel, Long> {
	
	List<DojoModel> findAll();

}
