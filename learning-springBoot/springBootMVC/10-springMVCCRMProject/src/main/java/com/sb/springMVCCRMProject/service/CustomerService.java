package com.sb.springMVCCRMProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.springMVCCRMProject.dao.ICustomerDao;
import com.sb.springMVCCRMProject.model.CustomerModel;

@Service("cService")
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	
	@Override
	public List<CustomerModel> getCustomers(){
		return (List<CustomerModel>) dao.findAll();
	}
	
	@Override
	public void registerCustomer(CustomerModel customer) {
		dao.save(customer);
	}

	@Override
	public CustomerModel getCustomer(Integer id) {
		Optional<CustomerModel> optional = dao.findById(id);
		return optional.get();
	}

	@Override
	public void deleteCustomer(Integer id) {
		dao.deleteById(id);
	}
}
