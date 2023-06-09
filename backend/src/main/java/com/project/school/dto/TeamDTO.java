package com.project.school.dto;

import java.io.Serializable;

import com.project.school.entites.Team;

public class TeamDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String name;
	private Integer series;

	public TeamDTO() {
	}

	public TeamDTO(Long id, String name, Integer series) {
		this.id = id;
		this.name = name;
		this.series = series;
	}
	
	public TeamDTO(Team entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.series = entity.getSeries();
	}

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

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}


}
