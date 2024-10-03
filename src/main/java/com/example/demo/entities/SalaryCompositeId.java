package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SalaryCompositeId implements Serializable{

	private static final long serialVersionUID = 2333019477803784318L;

	@Column(name = "emp_no", nullable = false, insertable = true, updatable = true)
	private Integer empNumber;
	
	@Column(name = "hire_date", nullable = false, insertable = true, updatable = true)
	private Date hireDate;
}
