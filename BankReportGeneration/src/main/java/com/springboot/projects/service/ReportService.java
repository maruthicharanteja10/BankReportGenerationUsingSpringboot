package com.springboot.projects.service;

import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	public List<String> getplanNames();

	public List<String> getplanstatus();

	public List<CitizenPlan> getsearchrequest(SearchRequest request);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
