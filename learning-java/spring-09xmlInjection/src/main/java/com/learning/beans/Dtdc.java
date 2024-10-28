package com.learning.beans;

public class Dtdc implements Courier
{
	   public Dtdc()
	   {
		   System.out.println("Dtdc obj created");
	   }
	public boolean deliver(String oid) 
	{
		System.out.println("Delivered using Dtdc service and order id : "+ oid);
		return true;
	}

}
