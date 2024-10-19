package com.sb.basicApp.dao;

import org.springframework.stereotype.Component;

import com.sb.basicApp.model.Student;

@Component
public class StudentDao {
	public void save(Student student) {
		System.out.println(student);
	}
}
