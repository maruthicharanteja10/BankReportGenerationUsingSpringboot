package com.springboot.projects.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.repository.CitizenPlanRepository;
import com.springboot.projects.request.SearchRequest;
import com.springboot.projects.util.EmailUtils;
import com.springboot.projects.util.ExcelGenerator;
import com.springboot.projects.util.PdfGenerator;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenPlanRepository planRepository;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils emailUtils;

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
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File f = new File("plans.xls");
		List<CitizenPlan> plans = planRepository.findAll();
		excelGenerator.generate(response, plans, f);
		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "charantejadonthireddy@gmail.com";

		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");
		List<CitizenPlan> plans = planRepository.findAll();
		pdfGenerator.generate(response, plans, f);
		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "charantejadonthireddy@gmail.com";

		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
