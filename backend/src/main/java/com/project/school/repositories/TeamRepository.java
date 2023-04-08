package com.project.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.entites.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

}
