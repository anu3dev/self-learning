package com.learning.beans;

public class FedEx implements Courier
{
   public FedEx()
   {
	   System.out.println("FedEx obj created");
   }
	public boolean deliver(String oid) 
	{
		System.out.println("Delivered using FedEx service and order id : "+ oid);
		return true;
	}

}
