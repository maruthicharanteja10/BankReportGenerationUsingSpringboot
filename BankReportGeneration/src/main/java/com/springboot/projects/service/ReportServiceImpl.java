package com.springboot.projects.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
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

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

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
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		Workbook workbook = new HSSFWorkbook();
		// Workbook workbook2=new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-Data");
		Row headerrow = sheet.createRow(0);
		headerrow.createCell(0).setCellValue("ID");
		headerrow.createCell(1).setCellValue("Citizen Name");
		headerrow.createCell(2).setCellValue("Gender");
		headerrow.createCell(3).setCellValue("PlanName");
		headerrow.createCell(4).setCellValue("PlanStatus");
		headerrow.createCell(5).setCellValue("StartDate");
		headerrow.createCell(6).setCellValue("EndDate");
		headerrow.createCell(7).setCellValue("BenfitAmt");

		List<CitizenPlan> records = planRepository.findAll();
		int rowdataindex = 1;
		for (CitizenPlan plan : records) {
			Row datarow = sheet.createRow(rowdataindex);
			datarow.createCell(0).setCellValue(plan.getCitizenId());
			datarow.createCell(1).setCellValue(plan.getCitizenName());
			datarow.createCell(2).setCellValue(plan.getGender());
			datarow.createCell(3).setCellValue(plan.getPlanName());
			datarow.createCell(4).setCellValue(plan.getPlanStatus());
			if (null != plan.getPlanStartDate()) {
				datarow.createCell(5).setCellValue(plan.getPlanStartDate() + "");
			} else {
				datarow.createCell(5).setCellValue("N/A");
			}
			if (null != plan.getPlanEndDate()) {
				datarow.createCell(6).setCellValue(plan.getPlanEndDate() + "");
			} else {
				datarow.createCell(6).setCellValue("N/A");
			}
			datarow.createCell(7).setCellValue(plan.getBenfitAmt());
			rowdataindex++;
		}
		FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
		workbook.write(fos);
		workbook.close();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		return false;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		Document document = new Document(PageSize.A3);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		// creating font
		// setting font style and size
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
		fontTitle.setSize(20);
		Paragraph p = new Paragraph("CitizenPlans", fontTitle);
		p.setAlignment(p.ALIGN_CENTER);
		document.add(p);

		PdfPTable table = new PdfPTable(8);
		table.setSpacingBefore(5);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("PlanName");
		table.addCell("PlanStatus");
		table.addCell("StartDate");
		table.addCell("EndDate");
		table.addCell("BenfitAmt");

		List<CitizenPlan> records = planRepository.findAll();
		for (CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate() + "");
			table.addCell(plan.getPlanEndDate() + "");
			table.addCell(plan.getBenfitAmt() + "");
		}
		document.add(table);
		document.close();
		return true;
	}

}
