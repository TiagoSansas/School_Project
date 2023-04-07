package com.project.school.dto;

import java.io.Serializable;

import com.project.school.entites.Class;

public class ClassDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String name;
	private Integer series;

	public ClassDTO() {
	}

	public ClassDTO(Long id, String name, Integer series) {
		this.id = id;
		this.name = name;
		this.series = series;
	}
	
	public ClassDTO(Class entity) {
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
