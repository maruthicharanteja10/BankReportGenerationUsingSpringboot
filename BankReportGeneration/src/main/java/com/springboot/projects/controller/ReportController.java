package com.springboot.projects.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.request.SearchRequest;
import com.springboot.projects.service.ReportService;
import com.springboot.projects.service.ReportServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	private ReportServiceImpl reportService;

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response, Model model) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		reportService.exportExcel(response);
	}

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response, Model model) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		reportService.exportPdf(response);
	}

	private void init(Model model) {
		model.addAttribute("names", reportService.getplanNames());
		model.addAttribute("status", reportService.getplanstatus());
	}

	@GetMapping("/")
	public String getpage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	@PostMapping("/searchData")
	public String searchdata(@ModelAttribute("search") SearchRequest search, Model model) {
		System.out.println(search);
		List<CitizenPlan> plans = reportService.getsearchrequest(search);
		model.addAttribute("plans", plans);
		// model.addAttribute("search", search);
		init(model);
		return "index";

	}
}
