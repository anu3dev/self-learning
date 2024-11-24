package com.anu3dev.service;

import java.util.List;

import com.anu3dev.model.CustomerInfo;

public interface ICustomerService {
	public List<CustomerInfo> getCustomers();
	public void registerCustomer(CustomerInfo customer);
	public CustomerInfo getCustomer(Integer id);
	public void deleteCustomer(Integer id);
}
