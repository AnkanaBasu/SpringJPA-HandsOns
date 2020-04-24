package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
