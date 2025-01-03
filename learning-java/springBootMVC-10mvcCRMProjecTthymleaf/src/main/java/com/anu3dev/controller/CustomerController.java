package com.anu3dev.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anu3dev.model.CustomerInfo;
import com.anu3dev.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	// http://localhost:8090
	@GetMapping("/list")
	public String fetchCustomerData(Model model){
		List<CustomerInfo> customerList = service.getCustomers();
		customerList.forEach((cus)->System.out.println(cus));
		model.addAttribute("customers",customerList);
		return "customerlist";
	}
	
	@GetMapping("/showForm")
	public String showForm(Map<String, Object> model){
		CustomerInfo customer=new CustomerInfo();
		model.put("customer", customer);
		return "showform";
	}
	
	@PostMapping("/registerCustomer")
	public String registerCustomer(@ModelAttribute("customer")CustomerInfo customer){
		service.registerCustomer(customer);
		return "redirect:/list";
	}
	
	@GetMapping("/updateForm")
	public String updateCustomer(@RequestParam("customerId") Integer id, Map<String, Object> model){
		CustomerInfo customer = service.getCustomer(id);
		model.put("customer", customer);
		return "showform";
	}
	
	@GetMapping("/deleteData")
	public String deleteCustomer(@RequestParam("customerId")Integer id){
		service.deleteCustomer(id);
		return "redirect:/list";
	}
}
