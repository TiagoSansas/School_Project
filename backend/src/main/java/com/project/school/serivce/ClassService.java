package com.project.school.serivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.school.dto.ClassDTO;
import com.project.school.entites.Class;
import com.project.school.repositories.ClassRepository;
import com.project.school.serivce.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClassService {

	@Autowired
	private ClassRepository repository;

	@Transactional(readOnly = true)
	public Page<ClassDTO> findAllPaged(PageRequest pageRequest) {
		Page<Class> list = repository.findAll(pageRequest);
		return list.map(x -> new ClassDTO(x));
	}

	@Transactional(readOnly = true)
	public ClassDTO findById(Long id) {
		Optional<Class> obj = repository.findById(id);
		Class entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
		return new ClassDTO(entity);
	}

	@Transactional
	public ClassDTO insert(ClassDTO dto) {
		Class entity = new Class();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClassDTO(entity);
	}

	@Transactional
	public ClassDTO update(Long id ,ClassDTO dto) {
		try {
			Class entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClassDTO(entity);
			
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

	private void copyDtoToEntity(ClassDTO dto, Class entity) {
		entity.setName(dto.getName());
		entity.setSeries(dto.getSeries());
	}

}
