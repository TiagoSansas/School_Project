package com.project.school.serivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.school.dto.StudantDTO;
import com.project.school.entites.Studant;
import com.project.school.entites.Team;
import com.project.school.repositories.StudantRepository;
import com.project.school.repositories.TeamRepository;
import com.project.school.serivce.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudantService {

	@Autowired
	private StudantRepository repository;

	@Autowired
	private TeamRepository teamRepository;

	@Transactional(readOnly = true)
	public Page<StudantDTO> findAllPaged(PageRequest pageRequest) {
		Page<Studant> list = repository.findAll(pageRequest);
		return list.map(x -> new StudantDTO(x));
	}

	@Transactional(readOnly = true)
	public StudantDTO findById(Long id) {
		Optional<Studant> obj = repository.findById(id);
		Studant entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new StudantDTO(entity);
	}

	@Transactional
	public StudantDTO insert(StudantDTO dto) {
		Studant entity = new Studant();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new StudantDTO(entity);
	}

	@Transactional
	public StudantDTO updated(Long id ,StudantDTO dto) {
		try {
		Studant entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new StudantDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		
	}

	private void copyDtoToEntity(StudantDTO dto, Studant entity) {
		entity.setName(dto.getName());
		entity.setAndress(dto.getAndress());
		entity.setNumberAndress(dto.getNumberAndress());
		entity.setNumberPhone(dto.getNumberPhone());
		entity.setRegistration(dto.getId());
		entity.setDate(dto.getDate());
		if (dto.getTeam().getId() != null) {
			Team team = new Team();
			team.setId(dto.getTeam().getId());
			entity.setTeam(team);
		}

	}
}
