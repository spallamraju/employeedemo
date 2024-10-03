package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Salary;
import com.example.demo.entities.SalaryCompositeId;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalaryRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demo/v1")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@GetMapping("/employee")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> fetchAllEmployees(){
		//log.info("Fetching All Employees!!!");
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{emp_no}")
	@ResponseStatus(value = HttpStatus.OK)
	public Employee fetchEmployeeByEmpNo(@PathVariable("emp_no") Integer empNumber) {
		Optional<Employee> employeeExist = employeeRepository.findById(empNumber);
		if (employeeExist.isPresent()) {
			return employeeExist.get();
		}
		return null;
	}
	
	@GetMapping("/employee/salary/{emp_no}")
	@ResponseStatus(value = HttpStatus.OK)
	public EmployeeDTO fetchEmployeeSalaryByEmpNo(@PathVariable("emp_no") Integer empNumber) {
		EmployeeDTO empDTO = new EmployeeDTO();
		Optional<Employee> employeeExist = employeeRepository.findById(empNumber);
		if (employeeExist.isPresent()) {
			Employee employee = employeeExist.get();
			empDTO.setEmpNumber(employee.getEmpNumber());
			empDTO.setFirstName(employee.getFirstName());
			empDTO.setLastName(employee.getLastName());
			
			SalaryCompositeId compositeId = new SalaryCompositeId(employee.getEmpNumber(), employee.getHireDate());
			//salary.
			Optional<Salary> salaryByIdObj = salaryRepository.findById(compositeId);
			if (salaryByIdObj.isPresent()) {
				Salary salary = salaryByIdObj.get();
				log.info("Salary Is: {}", salary.getSalary());	
				empDTO.setSalary(salary.getSalary());
			}
			return empDTO;
		}
		return null;

	}
}
