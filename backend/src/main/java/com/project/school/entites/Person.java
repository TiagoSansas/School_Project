package com.project.school.entites;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String andress;
	private Integer numberAndress;
	private Integer numberPhone;
	
	
	public Person() {}


	public Person(Long id, String name, String andress, Integer numberAndress, Integer numberPhone) {

		this.id = id;
		this.name = name;
		this.andress = andress;
		this.numberAndress = numberAndress;
		this.numberPhone = numberPhone;
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


	public String getAndress() {
		return andress;
	}


	public void setAndress(String andress) {
		this.andress = andress;
	}


	public Integer getNumberAndress() {
		return numberAndress;
	}


	public void setNumberAndress(Integer numberAndress) {
		this.numberAndress = numberAndress;
	}


	public Integer getNumberPhone() {
		return numberPhone;
	}


	public void setNumberPhone(Integer numberPhone) {
		this.numberPhone = numberPhone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}
	
}
