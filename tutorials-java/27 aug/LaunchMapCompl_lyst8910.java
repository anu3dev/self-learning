package com.telusko.learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Information
{
	private int age;
	private String name;
	private String city;
	public Information(int age, String name, String city) {
		super();
		this.age = age;
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "[age=" + age + ", name=" + name + ", city=" + city + "]";
	}
	
}
public class LaunchMapCompl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Information info1=new Information(16, "Mehu", "Bengaluru");
		Information info2=new Information(17, "Rohan", "Pune");
		Information info3=new Information(18, "Saurabh", "Mumbai");
		
		HashMap map=new HashMap();
		map.put(123, info1);
		map.put(111, info2);
		map.put(222, info3);
		
		
		System.out.println("Welcome to information center");
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the idenity number to get your infor");
		Integer key=scan.nextInt();
		Set set=map.entrySet();
		
		boolean flag=false;
		
		Iterator itr=set.iterator();
		while(itr.hasNext())
		{
			Map.Entry entry=(Entry) itr.next();
			Integer k=(Integer) entry.getKey();
			
			if(k==key)
			{
				System.out.println("The infor is : "+ entry.getValue());
				flag =true;
			}
			
		}
		if(flag==false)
		{
		System.out.println("Invalid ID");
		}

	}

}
