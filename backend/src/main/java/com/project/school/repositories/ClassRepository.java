package com.project.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.entites.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class,Long> {

}
