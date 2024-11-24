package com.sb.h2DBExample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.h2DBExample.model.Student;

// @Service to indicate that they’re holding the business logic
@Service
public class StudentService {
	@Autowired
	StudentDao dao;
	
	public void save(Student student) {
		dao.save(student);
	}
	
	public List<Student> getStudents() {
		return dao.findAll();
	}
}
