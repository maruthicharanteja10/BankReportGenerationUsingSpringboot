package com.springboot.projects.runner;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.springboot.projects.entity.CitizenPlan;
import com.springboot.projects.repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		citizenPlanRepository.deleteAll();
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Teja");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenfitAmt(8000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Anusha");
		c2.setGender("Female");
		c2.setPlanName("Food");
		c2.setPlanStatus("Denied");
		c2.setDenialRsn("Insufficient documents");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Raj");
		c3.setGender("Male");
		c3.setPlanName("Health");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(2));
		c3.setPlanEndDate(LocalDate.now().plusMonths(4));
		c3.setBenfitAmt(10000.00);
		c3.setTerminationRsn("Policy violation");

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Priya");
		c4.setGender("Female");
		c4.setPlanName("Education");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(12));
		c4.setBenfitAmt(12000.00);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Kiran");
		c5.setGender("Male");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Denied");
		c5.setDenialRsn("Income not eligible");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Neha");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(5));
		c6.setPlanEndDate(LocalDate.now().plusMonths(1));
		c6.setBenfitAmt(4000.00);
		c6.setTerminationRsn("Fraudulent application");

		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Arjun");
		c7.setGender("Male");
		c7.setPlanName("Health");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenfitAmt(9000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Sara");
		c8.setGender("Female");
		c8.setPlanName("Education");
		c8.setPlanStatus("Denied");
		c8.setDenialRsn("Application incomplete");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Ravi");
		c9.setGender("Male");
		c9.setPlanName("Cash");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(2));
		c9.setPlanEndDate(LocalDate.now().plusMonths(4));
		c9.setBenfitAmt(7000.00);
		c9.setTerminationRsn("Plan misused");

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Meera");
		c10.setGender("Female");
		c10.setPlanName("Food");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(8));
		c10.setBenfitAmt(11000.00);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Vijay");
		c11.setGender("Male");
		c11.setPlanName("Health");
		c11.setPlanStatus("Denied");
		c11.setDenialRsn("No supporting documents");

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Sita");
		c12.setGender("Female");
		c12.setPlanName("Education");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(7));
		c12.setPlanEndDate(LocalDate.now().plusMonths(3));
		c12.setBenfitAmt(15000.00);
		c12.setTerminationRsn("Policy breach");

		CitizenPlan c13 = new CitizenPlan();
		c13.setCitizenName("Ashok");
		c13.setGender("Male");
		c13.setPlanName("Employement");
		c13.setPlanStatus("Approved");
		c13.setPlanStartDate(LocalDate.now().minusMonths(1));
		c13.setPlanEndDate(LocalDate.now().plusMonths(5));
		c13.setBenfitAmt(9500.00);
	

		CitizenPlan c14 = new CitizenPlan();
		c14.setCitizenName("Lata");
		c14.setGender("Female");
		c14.setPlanName("Food");
		c14.setPlanStatus("Denied");
		c14.setDenialRsn("Insufficient income");

		CitizenPlan c15 = new CitizenPlan();
		c15.setCitizenName("Mohan");
		c15.setGender("Male");
		c15.setPlanName("Health");
		c15.setPlanStatus("Terminated");
		c15.setPlanStartDate(LocalDate.now().minusMonths(3));
		c15.setPlanEndDate(LocalDate.now().plusMonths(2));
		c15.setBenfitAmt(12000.00);
		c15.setTerminationRsn("Fraudulent activity");

		CitizenPlan c16 = new CitizenPlan();
		c16.setCitizenName("Kavitha");
		c16.setGender("Female");
		c16.setPlanName("Education");
		c16.setPlanStatus("Approved");
		c16.setPlanStartDate(LocalDate.now());
		c16.setPlanEndDate(LocalDate.now().plusMonths(10));
		c16.setBenfitAmt(8000.00);

		CitizenPlan c17 = new CitizenPlan();
		c17.setCitizenName("Gopal");
		c17.setGender("Male");
		c17.setPlanName("Cash");
		c17.setPlanStatus("Terminated");
		c17.setPlanStartDate(LocalDate.now().minusMonths(6));
		c17.setPlanEndDate(LocalDate.now().plusMonths(2));
		c17.setBenfitAmt(5000.00);
		c17.setTerminationRsn("Non-compliance with rules");

		CitizenPlan c18 = new CitizenPlan();
		c18.setCitizenName("Suman");
		c18.setGender("Female");
		c18.setPlanName("Food");
		c18.setPlanStatus("Approved");
		c18.setPlanStartDate(LocalDate.now());
		c18.setPlanEndDate(LocalDate.now().plusMonths(4));
		c18.setBenfitAmt(9500.00);

		CitizenPlan c19 = new CitizenPlan();
		c19.setCitizenName("Ravi Kumar");
		c19.setGender("Male");
		c19.setPlanName("Health");
		c19.setPlanStatus("Denied");
		c19.setDenialRsn("Incomplete application");

		CitizenPlan c20 = new CitizenPlan();
		c20.setCitizenName("Anjali");
		c20.setGender("Female");
		c20.setPlanName("Education");
		c20.setPlanStatus("Terminated");
		c20.setPlanStartDate(LocalDate.now().minusMonths(4));
		c20.setPlanEndDate(LocalDate.now().plusMonths(3));
		c20.setBenfitAmt(10000.00);
		c20.setTerminationRsn("Failed to comply with policies");

		List<CitizenPlan> lst = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16,
				c17, c18, c19, c20);

		citizenPlanRepository.saveAll(lst);

	}

}
