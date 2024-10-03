package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee implements Serializable {

	private static final long serialVersionUID = 6925190782529495182L;

	@Id
	@Column(name = "emp_no", nullable = false, insertable = true, updatable = true)
	private Integer empNumber;
	
	@Column(name = "first_name", nullable = false, insertable = true, updatable = true)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, insertable = true, updatable = true)
	private String lastName;
	
	@Column(name = "hire_date", nullable = false, insertable = true, updatable = true)
	private Date hireDate;
	
//	@JoinColumn
//	private Salary salary;
}
