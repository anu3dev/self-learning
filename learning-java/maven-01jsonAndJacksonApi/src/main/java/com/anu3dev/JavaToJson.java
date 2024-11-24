package com.anu3dev;

import java.util.ArrayList;
import java.util.List;

import com.anu3dev.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson {

	public static void main(String[] args) throws JsonProcessingException {
	
          Student st1 = new Student();
          st1.setId(101);
          st1.setName("Rohit");
          st1.setCity("Bengaluru");
          
          Student st2 = new Student();
          st2.setId(102);
          st2.setName("Rohan");
          st2.setCity("Pune");
          
          Student st3 = new Student();
          st3.setId(103);
          st3.setName("Deb");
          st3.setCity("Kolkata");
          
          List<Student> objList = new ArrayList<>();
          objList.add(st1);
          objList.add(st2);
          objList.add(st3);
          
          ObjectMapper mapper = new ObjectMapper();
          String json =  mapper.writerWithDefaultPrettyPrinter()
        		.writeValueAsString(objList);
          System.out.println(json);
	}
}
