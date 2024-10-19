package com.sb.basicApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sb.basicApp.model.Student;
import com.sb.basicApp.service.StudentService;

@SpringBootApplication

/*
 * @ComponentScan annotation is added to inform SB about folder structure, like scan this folder and get the bean.
 */
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println("");
		
		/*
		 *  In spring, class called as bean.
		 */
		Student student1 = context.getBean(Student.class);
		student1.setId(1);
		student1.setName("anurag");
		student1.setAge(30);
		student1.setCity("patna");
		
		Student student2 = context.getBean(Student.class);
		student2.setId(2);
		student2.setName("seema");
		student2.setAge(31);
		student2.setCity("pune");
		
		StudentService service = context.getBean(StudentService.class);
		/*
		 * without @Scope(value = "prototype") in Student, 
		 * both student1 and student2 will produce same result due to singleton behavior of bean container.
		 */
		service.addStudent(student1);
		service.addStudent(student2);
		
		System.out.println("");
	}
}
