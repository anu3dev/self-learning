package com.learning.beans;

import java.util.Random;

public class FlipKart 
{
	private Courier courier;
	private Float discount;
	
	
//public FlipKart(Courier courier, Float discount) {
//		super();
//		this.courier = courier;
//		this.discount = discount;
//		System.out.println("Constructor inject using param cons");
//	}
	
//	public FlipKart(Courier courier) {
//		super();
//		this.courier = courier;
//		
//		System.out.println("Constructor inject using param cons");
//	}
	
//   public void setDiscount(Float discount) {
//		this.discount = discount;
//	}
public FlipKart()
   {
	   System.out.println("target class Flipkart bj is created");
   }
	public void setCourier(Courier courier) 
	{
		this.courier = courier;
		
		System.out.println("Setter called for DI and Autowiring");
	}
	
	///Business logic
	public boolean shipment(String []item)
	{
		
		
		//System.out.println("Implementing got inject is :  " + courier.getClass().getName());
		System.out.println("The items purchased are");
		for(String elem: item)
		{
			System.out.print(elem + " , ");
		}
		System.out.println();
		 Random random=new Random();
		 int oid=random.nextInt(1000);
		courier.deliver(" "+oid);
		return true;
	}
	
	
	
	

}
