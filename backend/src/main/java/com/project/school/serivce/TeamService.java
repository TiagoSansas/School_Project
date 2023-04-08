package com.project.school.serivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.school.dto.TeamDTO;
import com.project.school.entites.Team;
import com.project.school.repositories.TeamRepository;
import com.project.school.serivce.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeamService {

	@Autowired
	private TeamRepository repository;

	@Transactional(readOnly = true)
	public Page<TeamDTO> findAllPaged(PageRequest pageRequest) {
		Page<Team> list = repository.findAll(pageRequest);
		return list.map(x -> new TeamDTO(x));
	}

	@Transactional(readOnly = true)
	public TeamDTO findById(Long id) {
		Optional<Team> obj = repository.findById(id);
		Team entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
		return new TeamDTO(entity);
	}

	@Transactional
	public TeamDTO insert(TeamDTO dto) {
		Team entity = new Team();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TeamDTO(entity);
	}

	@Transactional
	public TeamDTO update(Long id ,TeamDTO dto) {
		try {
			Team entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new TeamDTO(entity);
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);;
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	private void copyDtoToEntity(TeamDTO dto, Team entity) {
		entity.setName(dto.getName());
		entity.setSeries(dto.getSeries());
	}

}
