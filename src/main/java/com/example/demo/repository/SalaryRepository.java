package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Salary;
import com.example.demo.entities.SalaryCompositeId;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryCompositeId> {

}
