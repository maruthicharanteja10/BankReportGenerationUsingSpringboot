package com.springboot.projects.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.repository.CitizenPlanRepository;
import com.springboot.projects.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService {
	private CitizenPlanRepository planRepository;

	public ReportServiceImpl(CitizenPlanRepository planRepository) {
		super();
		this.planRepository = planRepository;
	}

	@Override
	public List<String> getplanNames() {
		return planRepository.getAllPlanNames();
	}

	@Override
	public List<String> getplanstatus() {
		return planRepository.getAllPlanStatus();
	}

	@Override
	public List<CitizenPlan> getsearchrequest(SearchRequest request) {
		return planRepository.findAll();
	}

	@Override
	public boolean exportExcel() {
		return false;
	}

	@Override
	public boolean exportPdf() {
		return false;
	}

}
