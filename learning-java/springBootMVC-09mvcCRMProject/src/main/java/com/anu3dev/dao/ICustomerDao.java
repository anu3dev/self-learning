package com.anu3dev.dao;

import org.springframework.data.repository.CrudRepository;

import com.anu3dev.model.CustomerModel;

public interface ICustomerDao extends CrudRepository<CustomerModel, Integer>{}
