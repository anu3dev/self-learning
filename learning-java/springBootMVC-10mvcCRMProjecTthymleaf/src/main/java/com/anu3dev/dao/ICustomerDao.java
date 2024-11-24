package com.anu3dev.dao;

import org.springframework.data.repository.CrudRepository;

import com.anu3dev.model.CustomerInfo;

public interface ICustomerDao extends CrudRepository<CustomerInfo,Integer>{}
