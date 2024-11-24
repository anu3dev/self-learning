package com.anu3dev.service;

import java.util.List;

import com.anu3dev.model.CustomerModel;

public interface ICustomerService {
	public List<CustomerModel> getCustomers();
	public void registerCustomer(CustomerModel customer);
	public CustomerModel getCustomer(Integer id);
	public void deleteCustomer(Integer id);
}
