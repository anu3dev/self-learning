package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Customer")
public class CustomerInfo 
{
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;
      
      private String firstName;
      private String lastName;
      private String city;
      
      public CustomerInfo()
      {
    	  System.out.println("Customer obj zero param constructor");
      }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ "]";
	}
      
      
      
      
}
