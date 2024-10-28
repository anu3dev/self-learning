package com.sb.mySQLExample.dao;

import java.util.List;

import com.sb.mySQLExample.model.Student;

public interface StudentDao {
	List<Student> getStudents();
}
