package com.telusko.learning;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class LaunchSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet set=new TreeSet();
		set.add(100);
		set.add(50);
		set.add(150);
		set.add(25);
		set.add(75);
		set.add(125);
		set.add(175);
		
		
		System.out.println(set);
		

		LinkedList ll=new LinkedList();
		ll.add(100);
		ll.add(20);
		ll.add(300);
		ll.add(45);
		System.out.println(ll);
		
		Collections.sort(ll);
		System.out.println("Sorted data : ");
		System.out.println(ll);
		
		System.out.println("Shuffld data : ");
		Collections.shuffle(ll);
		System.out.println(ll);
		
		int freq=Collections.frequency(ll, 20);
		System.out.println(freq);
	
		Collections.rotate(ll, 1);
		System.out.println("After rotating ");
		System.out.println(ll);

	}

}
