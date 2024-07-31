package com.sb.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.pojo.Customer;

public class LaunchApp {
	public static void main(String[] args) {
		ObjectMapper mapper=new ObjectMapper();
		try {			
			Customer customer = mapper.readValue(new File("data/simple-full.json"), Customer.class);			
			
			System.out.println("Customer id "+ customer.getId());
			System.out.println("Customer firstName "+ customer.getFirstName());
			System.out.println("Customer lastName "+ customer.getLastName());
			System.out.println("Customer is Active "+ customer.getActive());
			System.out.println("Customer full address " + customer.getAddress());
			
			for(String data:customer.getLanguages()){
				System.out.println(data);
			}
		} 
		catch (StreamReadException e) {	
			e.printStackTrace();
		} catch (DatabindException e) {	
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
}
