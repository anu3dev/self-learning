package com.sb.SpringBootApp.entity;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// @Repository is optional
public interface EmployeeDetails extends CrudRepository<Employee, Serializable> {}
