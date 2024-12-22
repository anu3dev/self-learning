package com.anu3dev.service;

import com.anu3dev.model.Student;

public interface IGreetings {
	String generateWish(String name);
	Boolean addStudent(Student st);
}
