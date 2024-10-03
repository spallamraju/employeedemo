package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Integer empNumber;
	private String firstName;
	private String lastName;
	private Date hireDate;
	private Integer salary;
	
}
