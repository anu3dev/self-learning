package com.telusko.learning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class LaunchFFFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList list=new ArrayList();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(50);
		list.add(40);
	   
		System.out.println(list);
		
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i));
//			list.add(445);
//		}
		
//		Iterator itr=list.iterator();
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//			list.add(445);
//		}
//		
		CopyOnWriteArrayList list1=new CopyOnWriteArrayList();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(50);
		list1.add(40);
	   
		System.out.println(list1);
		
		for(Object obj: list1)
		{
			System.out.println(obj);
			list1.add(556);
		}
		
		Iterator itr=list1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
			list1.add(445);
		}
		

	}

}
