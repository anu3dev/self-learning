package com.telusko.learning;

import java.util.*;

;

public class LaunchADP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList list=new ArrayList();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(50);
		list.add(40);
	   
		System.out.println(list);
		
//		Object obj1=list.get(2);
//		
//		Integer in=(Integer) list.get(4);
//		
//		System.out.println("For loop");
//		
//		for(int i=0; i<list.size();i++)
//		{
//			Object obj=list.get(i);
//			System.out.println(obj);
//		}
//		
//		System.out.println("For each loop / enchanced for loop");
//		
//		for(Object obj:list)
//		{
//			System.out.println(obj);
//			
//		}
		
		Iterator itr=list.iterator();
		
//		boolean status=itr.hasNext();
//		if(status)
//			System.out.println(itr.next());
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		ListIterator litr=list.listIterator();
		while(litr.hasNext())
		{
			System.out.println(litr.next());
		}
		ListIterator litr2=list.listIterator(list.size());
		while(litr2.hasPrevious())
		{
			System.out.println(litr2.previous());
		}
		
		
		

	}

}
