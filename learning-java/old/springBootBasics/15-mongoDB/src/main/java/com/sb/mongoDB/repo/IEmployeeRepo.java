package com.sb.mongoDB.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEmployeeRepo extends MongoRepository<Employee, String> {
	public List<Employee> findByBillAmntBetween(float start, float end);
    
    public List<Employee> findByCityIn(String ...cities);
}
