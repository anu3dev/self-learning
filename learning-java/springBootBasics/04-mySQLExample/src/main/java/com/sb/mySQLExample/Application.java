package com.sb.mySQLExample;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.mySQLExample.dao.StudentService;
import com.sb.mySQLExample.model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println("Beans created internally by Spring boot : "+ Arrays.toString(context.getBeanDefinitionNames()));
		
		StudentService stuDao = context.getBean(StudentService.class);
		List<Student> list= stuDao.getStudents();
		
		Iterator itr=list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		((ConfigurableApplicationContext) context).close();
	}
}
