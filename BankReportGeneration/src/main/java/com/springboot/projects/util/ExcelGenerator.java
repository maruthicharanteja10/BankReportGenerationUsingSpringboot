package com.springboot.projects.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.springboot.projects.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	// Apache POI (ThirdParty)
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File f) throws Exception {

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
			if (null != plan.getBenfitAmt()) {
				datarow.createCell(7).setCellValue(plan.getBenfitAmt());
			} else {
				datarow.createCell(7).setCellValue("N/A");
			}

			rowdataindex++;
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		workbook.close();
	}
}
