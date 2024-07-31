package com.anu3dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu3dev.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {}
