package com.sb.ymlFileExample.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("emp")
@ConfigurationProperties(prefix="emp.info")
public class Employee {
	
	private String name;
	private Integer id;
	private String[] tasks;
	private List<String> teamMembers;
	private Set<Long> phoneNumbers;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", tasks=" + Arrays.toString(tasks) + ", teamMembers="
				+ teamMembers + ", phoneNumbers=" + phoneNumbers + "]";
	}
}
