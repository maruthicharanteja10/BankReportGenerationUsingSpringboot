package com.springboot.projects.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.projects.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	// itext-pdf/open-pdf/ aspose
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File f) throws Exception {
		Document document = new Document(PageSize.A3);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
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

		for (CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			if (null != plan.getPlanStartDate()) {
				table.addCell(plan.getPlanStartDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != plan.getPlanStartDate()) {
				table.addCell(plan.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != plan.getPlanStartDate()) {
				table.addCell(plan.getBenfitAmt() + "");
			} else {
				table.addCell("N/A");
			}
		}
		document.add(table);
		document.close();

		
	}
}
