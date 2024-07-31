package com.sb.springMVCCRMProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.sb.springMVCCRMProject.model.CustomerModel;
import com.sb.springMVCCRMProject.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	@GetMapping
	public String getAllCustomerData(Model model) {
		List<CustomerModel> cust =  service.getCustomers();
		model.addAttribute("customerList", cust);
		return "customerList";
	}
	
	@GetMapping("/registerCustomer")
	public String registerCustomer(Map<String, Object> map) {
		CustomerModel cust = new CustomerModel();
		map.put("customer", cust);
		return "registerCustomer";
	}
	
	@GetMapping("/registerSuccess")
	public String registerSuccess(@ModelAttribute("customer")CustomerModel customer) {
		service.registerCustomer(customer);
		return "registerSuccess";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") Integer id, Map<String, Object> map) {
		CustomerModel cust = service.getCustomer(id);
		map.put("customer", cust);
		return "registerCustomer";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") Integer id) {
		service.deleteCustomer(id);
		return "redirect:/";
	}
}
