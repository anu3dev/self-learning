package com.anu3dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Employee;

@RestController
public class Hello {
	private List<Employee> students = new ArrayList<>(
            List.of(
                    new Employee(1, "Navin", "hello", "hello@gm.co"),
                    new Employee(2, "Kiran", "hello", "hello@gm.co")
            ));

    @GetMapping("/emp")
    public List<Employee> getStudents() {
        return students;
    }
}
