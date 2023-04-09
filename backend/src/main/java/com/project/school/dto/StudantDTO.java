package com.project.school.dto;

import java.time.Instant;

import com.project.school.entites.Person;
import com.project.school.entites.Studant;
import com.project.school.entites.Team;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class StudantDTO extends Person {

	private static final long serialVersionUID = 1L;


	private Long registration;
	private Instant date;
	private Team team;



	public StudantDTO() {
	}

	public StudantDTO(Long id, String name, String andress, Integer numberAndress, Integer numberPhone,
			 Instant date,Team team ) {
		super(id, name, andress, numberAndress, numberPhone);
		this.registration = id;
		this.date = date;
		this.team = team;
	
	}
	public StudantDTO(Studant entity) {
		
		this.setId(entity.getId());
		this.setName(entity.getName());
		this.setAndress(entity.getAndress());
		this.setNumberAndress(entity.getNumberAndress());
		this.setNumberPhone(entity.getNumberPhone());
		this.registration = entity.getId();
		this.date = entity.getDate();
		
	}



	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}



	
	

}
