package com.project.school.dto;

import java.time.Instant;

import com.project.school.entites.Person;
import com.project.school.entites.Studant;
import com.project.school.entites.Team;

public class StudantDTO extends Person {

	private static final long serialVersionUID = 1L;

	private Long registration;
	private Instant date;



	public StudantDTO() {
	}

	public StudantDTO(Long id, String name, String andress, Integer numberAndress, Integer numberPhone,
			Long registration, Instant date) {
		super(id, name, andress, numberAndress, numberPhone);
		this.registration = registration;
		this.date = date;
	}
	public StudantDTO(Studant entity) {
		
		this.setId(entity.getId());
		this.setName(entity.getName());
		this.setAndress(entity.getAndress());
		this.setNumberAndress(entity.getNumberAndress());
		this.setNumberPhone(entity.getNumberPhone());
		this.registration =entity.getRegistration();
		this.date = entity.getDate();
	}
	public StudantDTO(Studant entity, Team team) {
		this(entity);
		team.getId();
	}
	
	
}
