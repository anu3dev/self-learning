package com.telusko.learning;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LaunchHashS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet hs=new HashSet();
		
		hs.add(100);
		hs.add(100);
		hs.add(300);
		hs.add(400);
		hs.add(500);
		
		System.out.println(hs);
		
		LinkedHashSet lhs=new LinkedHashSet();
		
		lhs.add(100);
		lhs.add(100);
		lhs.add(300);
		lhs.add(400);
		lhs.add(500);
		
		System.out.println(lhs);

	}

}
