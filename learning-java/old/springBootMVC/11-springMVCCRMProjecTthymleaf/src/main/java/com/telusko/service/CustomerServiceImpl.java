package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.dao.ICustomerDao;
import com.telusko.model.CustomerInfo;

@Service("cService")
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	private ICustomerDao dao;

	@Override
	public List<CustomerInfo> getCustomers() 
	{
		return (List<CustomerInfo>) dao.findAll();
		
	}

	@Override
	public void registerCustomer(CustomerInfo customer) {
		dao.save(customer);
		
	}

	@Override
	public CustomerInfo getCustomer(Integer id) {
		Optional<CustomerInfo> optional = dao.findById(id);
		
		return optional.get();
	}

	@Override
	public void deleteCustomer(Integer id) {
		dao.deleteById(id);
		
	}

}
