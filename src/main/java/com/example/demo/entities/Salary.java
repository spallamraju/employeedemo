package com.example.demo.entities;

import java.io.Serializable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "salaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Salary implements Serializable {

	private static final long serialVersionUID = 2069332290775189585L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride( name="emp_no", column = @Column),
			@AttributeOverride(name="hire_date", column = @Column )
	})
	private SalaryCompositeId salaryCompositeKey;
	
	@Column(name = "salary", nullable = false, insertable = true, updatable = true)
	private Integer salary;
	
}
