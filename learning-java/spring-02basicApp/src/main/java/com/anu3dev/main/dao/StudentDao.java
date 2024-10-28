package com.anu3dev.main.dao;

import org.springframework.stereotype.Component;

import com.anu3dev.main.model.Student;

@Component
public class StudentDao {
	public void save(Student student) {
		System.out.println("stored " + student);
	}
}
