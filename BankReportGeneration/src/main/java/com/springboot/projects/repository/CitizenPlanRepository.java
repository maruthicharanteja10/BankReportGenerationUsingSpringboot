package com.springboot.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.projects.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getAllPlanNames();
	
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getAllPlanStatus();
	
	@Query("select distinct(gender) from CitizenPlan")
	public List<String> getAllGender();
	
}
