package com.springboot.projects.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
		CitizenPlan entity = new CitizenPlan();
		// request has empty , citizen plan object has null data so it will not display
		// data ,so we can check null and empty data

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			entity.setPlanStartDate(request.getStartDate());
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			entity.setPlanEndDate(request.getEndDate());
		}
//		BeanUtils.copyProperties(request, entity);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("benfitAmt"); // Exclude benfit_amt from
																							// matching

		return planRepository.findAll(Example.of(entity, matcher));
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
