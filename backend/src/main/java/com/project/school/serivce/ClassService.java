package com.project.school.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.school.dto.ClassDTO;
import com.project.school.entites.Class;
import com.project.school.repositories.ClassRepository;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClassDTO> findAllPaged(PageRequest pageRequest){
		Page<Class> list = repository.findAll(pageRequest);
		return list.map(x->new ClassDTO(x));
	}
	

}
