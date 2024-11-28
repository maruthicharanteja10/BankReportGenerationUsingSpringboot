package com.springboot.projects.service;

import java.util.List;

import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.request.SearchRequest;

public interface ReportService {
	public List<String> getplanNames();

	public List<String> getplanstatus();

	public List<CitizenPlan> getsearchrequest(SearchRequest request);

	public boolean exportExcel();

	public boolean exportPdf();
}
