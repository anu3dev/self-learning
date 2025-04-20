package com.telusko.learning;

import java.util.*;

public class LaunchLinkedL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList ll=new LinkedList();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		System.out.println(ll);
		ll.add(2, 500);
		ll.addFirst(1000);
		ll.addLast(2000);
		System.out.println(ll);
		
		System.out.println("**************************************");
		
		LinkedList list2=new LinkedList();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(30);
		list2.add(50);
		list2.add(60);
		System.out.println(list2);
		System.out.println(list2.peekFirst());
		System.out.println(list2);
		System.out.println(list2.pollFirst());
		System.out.println(list2);
		list2.add(100);
		System.out.println(list2);
		list2.offer(200);
		System.out.println(list2);
		
		
		

	}

}
