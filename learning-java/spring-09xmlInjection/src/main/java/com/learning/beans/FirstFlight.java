package com.learning.beans;

public class FirstFlight implements Courier
{
	   public FirstFlight()
	   {
		   System.out.println("FightFlight obj created");
	   }
	public boolean deliver(String oid) 
	{
		System.out.println("Delivered using FirstFlight service and order id : "+ oid);
		return true;
	}

}
