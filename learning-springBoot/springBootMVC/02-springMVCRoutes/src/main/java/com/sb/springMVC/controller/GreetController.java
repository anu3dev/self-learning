package com.sb.springMVC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sb.springMVC.controller.service.GreetService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GreetController {
	@Autowired
	private GreetService greeting;
	
	@GetMapping
	public String welcome(Model model){
		model.addAttribute("wish", "welcome!");
		return "home";
	}
	
	@GetMapping("/model")
	public String greeting(Model model){
		model.addAttribute("wish", greeting.greetMe() + " using Model");
		return "home";
	}
	
	@GetMapping("/modelView")
	public ModelAndView greeting(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("wish", greeting.greetMe() + " using ModelAndView");
		mav.setViewName("home");
		return mav;
	}
	
	@GetMapping("/map")
	public String greeting(Map<String, Object> map){
		map.put("wish", greeting.greetMe() + " using Map");
		return "home";
	}
	
	@GetMapping("/hashMap")
	public String greeting(HashMap<String, Object> hashMap){
		hashMap.put("wish", greeting.greetMe() + " using HashMap");
		return "home";
	}
	
	@GetMapping("/http")
	public void showResponse(HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1 style=\"color: green\">"+ greeting.greetMe() + " using HttpServletResponse</h1>");
	}
}
