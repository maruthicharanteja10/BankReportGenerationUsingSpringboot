package com.springboot.projects.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;


}