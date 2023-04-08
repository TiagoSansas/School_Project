package com.project.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudantRepository extends JpaRepository<StudantRepository,Long> {}


