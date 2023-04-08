package com.project.school.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.school.dto.StudantDTO;
import com.project.school.entites.Studant;
import com.project.school.repositories.StudantRepository;
import com.project.school.repositories.TeamRepository;

@Service
public class StudantService {

	@Autowired
	private StudantRepository repository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Transactional (readOnly =true)
	public Page<StudantDTO> findAllPaged(PageRequest pageRequest){
		Page<Studant> list = repository.findAll(pageRequest);
		return list.map(x-> new StudantDTO(x));
	}
}
