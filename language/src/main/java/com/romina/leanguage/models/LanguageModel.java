package com.romina.leanguage.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "languages")
public class LanguageModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 20, message = "Por favor agregue un nombre de entre 2 a 20 caracteres.")
	private String name;

	@Size(min = 2, max = 20, message = "Por favor agregue un creador de entre 2 a 20 caracteres.")
	private String creator;
	
	@Size(min = 0, message = "Por favor agregue una version.")
	private String numberOfVersion;
	
	// ESTO NO PERMITIRÁ QUE EL CAMPO CREATEDAT SEA MODIFICADO DESPUÉS DE SU CREACION
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	//CONSTRUCTORES
	public LanguageModel() {
		
	}
	public LanguageModel(String name, String creator, String numberOfVersion) {
		this.name = name;
		this.creator = creator;
		this.numberOfVersion = numberOfVersion;
	}
	public LanguageModel(Long id,String name, String creator, String numberOfVersion) {
		this.name = name;
		this.creator = creator;
		this.numberOfVersion = numberOfVersion;
	}
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getNumberOfVersion() {
		return numberOfVersion;
	}
	public void setNumberOfVersion(String numberOfVersion) {
		this.numberOfVersion = numberOfVersion;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	    
	
	
}
