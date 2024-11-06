package com.anu3dev.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anu3dev.main.dao.StudentDao;
import com.anu3dev.main.model.Student;

@Component
public class StudentService {
	@Autowired
	private StudentDao dao;
	
	public void addStudent(Student student) {
		dao.save(student);
	}
}
