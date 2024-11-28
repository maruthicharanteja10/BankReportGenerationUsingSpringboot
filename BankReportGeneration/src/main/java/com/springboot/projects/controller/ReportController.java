package com.springboot.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.request.SearchRequest;
import com.springboot.projects.service.ReportService;
import com.springboot.projects.service.ReportServiceImpl;

@Controller
public class ReportController {
	@Autowired
	private ReportServiceImpl reportService;

	private void init(Model model) {
		model.addAttribute("request", new SearchRequest());
		model.addAttribute("names", reportService.getplanNames());
		model.addAttribute("status", reportService.getplanstatus());
	}

	@GetMapping("/")
	public String getpage(Model model) {
	
		init(model);
		return "index";
	}

	@PostMapping("/search")
	public String searchdata(SearchRequest request, Model model) {
		System.out.println(request);
		List<CitizenPlan> plans=reportService.getsearchrequest(request);
		model.addAttribute("plans",plans);
		
		init(model);
		return "index";

	}
}
