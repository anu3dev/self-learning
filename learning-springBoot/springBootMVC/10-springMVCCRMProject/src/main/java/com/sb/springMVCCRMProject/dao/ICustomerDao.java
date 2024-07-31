package com.sb.springMVCCRMProject.dao;

import org.springframework.data.repository.CrudRepository;

import com.sb.springMVCCRMProject.model.CustomerModel;

public interface ICustomerDao extends CrudRepository<CustomerModel, Integer>{}
