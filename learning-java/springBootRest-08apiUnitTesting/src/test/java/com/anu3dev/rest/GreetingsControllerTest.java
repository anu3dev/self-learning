package com.anu3dev.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.anu3dev.model.Student;
import com.anu3dev.service.IGreetings;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTest {
	@MockBean
	private IGreetings service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	// @Disabled - we can disable like this
	void testGetWishes() throws Exception {
		//Mocking
		Mockito.when(service.generateWish("Suresh")).thenReturn("Good Morning");
		
		//RequestObject
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		ResultActions result = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = result.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		int statusCode=response.getStatus();
		//Assertion
		assertEquals(200,statusCode);
	}
	
	@Test
	void testAddStudent() throws Exception{
		//Mocking
		Mockito.when(service.addStudent(ArgumentMatchers.any())).thenReturn(true);
		
		Student student=new Student(1,"Rohan","Bengaluru");
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(student);
		
		//RequestBuilder
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json);
		
		ResultActions result = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = result.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		int statusCode=response.getStatus();
		//Assertion
		assertEquals(200,statusCode);
	}
}
