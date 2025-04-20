package com.telusko.learning;

import java.util.HashMap;
import java.util.WeakHashMap;

class Employee4
{
	int id;
	String name;
	@Override
	public String toString() {
		return "Employee4 [id=" + id + ", name=" + name + "]";
	}
	
	//setters
	//getter
	@Override
	public void finalize()
	{
		System.out.println("Obj cleaning by Garbage collector");
	}
}


public class LaunchWeak 
{
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Employee4 emp=new Employee4();
      //HashMap hm=new HashMap();
		
		
		WeakHashMap hm=new WeakHashMap();
		hm.put(emp, "Telusko");
		
		System.out.println(hm);
		
		///
		
		emp=null;
		
		
		System.gc();
		
		Thread.sleep(4000);
		
		System.out.println(hm);
		
		

	}

}
