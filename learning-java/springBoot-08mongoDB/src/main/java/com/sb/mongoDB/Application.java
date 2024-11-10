package com.sb.mongoDB;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.mongoDB.dto.EmployeeDTO;
import com.sb.mongoDB.repo.Employee;
import com.sb.mongoDB.service.EmployeeManagement;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeManagement emp = context.getBean(EmployeeManagement.class);
		
		EmployeeDTO dto = new EmployeeDTO(); 
		dto.setNo(1);
		dto.setName("rupa");
		dto.setAge(29);
		dto.setCity("Bengaluru");
		dto.setBillAmnt(444.4f);
		System.out.println(emp.registerEmployee(dto));
		System.out.println(emp.registerCustomerWithUniqueID(dto));
		
		List<Employee> employeeList = emp.findAllEmployee();
		employeeList.forEach(c->System.out.println(c));
		
		System.out.println(emp.removeEmployee("658674c06b51cb45fa9fb1c8"));
		
		emp.fetchByBillAmntBetween(424.4f, 4854.5f).forEach(c->System.out.println(c));
		
		emp.fetchByCityIn("Bengaluru", "Pune", "Chennai").forEach(c->System.out.println(c));
		
		context.close();
	}
}

/*
 * JPARepository extends pagingandsortingRepository extends crudRepository extends Repository
 * MongoRepository extends pagingandsortingRepository extends crudRepository extends Repository 
 *
 * Dependencies =>
 * Spring Data MongoDB
 * Lombok
 * 
 * in mongoDB, data stored in form of JSON.
 *
 * table means collection.
 * data will be stored not in row and column, it will be in documents.
 *   
 * mongod --version --> check mongo DB version.
 * mongosh --version --> check mongo DB shell version.
 * mongosh --> to access mongo DB via CMD.
 * show dbs --> see list of available DB.
 * use learn --> select DB.
 * db.createCollection('employee') --> create collection within DB.
 * show collections --> show list of collection within DB.
 * db.employee.insertOne({id: 1, name: "Anurag"}) --> insert one document to collection.
 * db.employee.find().pretty() --> see inserted document from collection.
 * db.employee.insertMany([{age:34, name: "nitish"},{age:31, name: "seema"}]) --> insert multiple document to collection.
 * db.employee.updateOne({id: 1}, {$set:{name:"anu"}}) --> update one document to collection.
 * db.employee.deleteOne({id: 1}) --> delete one document to collection. 
 */