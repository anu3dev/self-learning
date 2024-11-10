package com.anu3dev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anu3dev.service.GreetService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GreetController {
	@Autowired
	private GreetService greeting;
	
	// http://localhost:8090/
	@GetMapping
	public String welcome(Model model){
		model.addAttribute("wish", "welcome!");
		return "home";
	}
	
	// http://localhost:8090/model
	@GetMapping("/model")
	public String greeting(Model model){
		model.addAttribute("wish", greeting.greetMe() + " using Model");
		return "home";
	}
	
	// http://localhost:8090/modelView
	@GetMapping("/modelView")
	public ModelAndView greeting(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("wish", greeting.greetMe() + " using ModelAndView");
		mav.setViewName("home");
		return mav;
	}
	
	// http://localhost:8090/map
	@GetMapping("/map")
	public String greeting(Map<String, Object> map){
		map.put("wish", greeting.greetMe() + " using Map");
		return "home";
	}
	
	// http://localhost:8090/hashMap
	@GetMapping("/hashMap")
	public String greeting(HashMap<String, Object> hashMap){
		hashMap.put("wish", greeting.greetMe() + " using HashMap");
		return "home";
	}
	
	// http://localhost:8090/http
	@GetMapping("/http")
	public void showResponse(HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1 style=\"color: green\">"+ greeting.greetMe() + " using HttpServletResponse</h1>");
	}
}
