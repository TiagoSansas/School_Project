package com.project.school.entites;

import java.time.Instant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_stutant")
public class Studant extends Person {

	private static final long serialVersionUID = 1L;
	
	
	private Long registration;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;

	@OneToOne(cascade = CascadeType.ALL)
	
	@JoinColumn(name = "team_id",referencedColumnName="id")

	private Team team;
	
	public Studant() {
	}

	public Studant(Long id, String name, String andress, Integer numberAndress, Integer numberPhone, Long registration,
			Instant date) {
		super(id, name, andress, numberAndress, numberPhone);
		this.registration = registration;
		this.date = date;

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
	
}
