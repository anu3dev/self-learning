package com.telusko.learning;

import java.util.TreeSet;

public class LaunchTS {

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
		
		System.out.println(set.ceiling(65));//75
		System.out.println(set.higher(65));//75
		
		System.out.println(set.ceiling(75));//75
		//it will search for 75 if its present it will return same else it will return higher object
		
		System.out.println(set.higher(75));//100
		//it will search and return higher obhect than 75
		
		System.out.println(set.floor(75));//75
		System.out.println(set.floor(65));//50
		
		System.out.println(set.lower(75));//50
		
		System.out.println(set.tailSet(50));//50 75 100 125  150 175
		System.out.println(set.headSet(50)); //25
		
		
	}

}
