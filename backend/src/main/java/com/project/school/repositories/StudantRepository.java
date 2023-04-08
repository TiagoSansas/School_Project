package com.project.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.entites.Studant;


@Repository
public interface StudantRepository extends JpaRepository<Studant,Long> {}


