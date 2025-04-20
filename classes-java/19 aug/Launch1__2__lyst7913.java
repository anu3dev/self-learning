package com.telusko.learning;


import java.util.*;

public class Launch1 {

	public static void main(String[] args) 
	{
		//int ar[]= {10,"Telusko"}; error
		
		//ArrayList list1=new ArrayList(); same as next line
		
		List list1=new ArrayList();
		
		list1.add(10);
		list1.add("Telusko");
		list1.add('N');
		list1.add(14.45);
		
		System.out.println(list1);
		
		System.out.println("***********************************");
		
		List list2=new ArrayList();
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		System.out.println(list2);
		list2.add(1, 600);
		System.out.println(list2);
		list2.addAll(list1);
		System.out.println(list2);
		
		
		System.out.println("************************************");
		
		ArrayList list3=new ArrayList();
		list3.add(10);
		list3.add(20);
		list3.add(30);
		list3.add(30);
		list3.add(50);
		
		System.out.println(list3);
		//list3.clear();
		System.out.println(list3.contains(20));
//		int index=list3.indexOf(30);
//		System.out.println(index);
		System.out.println(list3.indexOf(30));
		System.out.println(list3.size());
	
		System.out.println(list3);
		

	}

}
