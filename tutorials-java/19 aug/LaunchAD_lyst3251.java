package com.telusko.learning;

import java.util.ArrayDeque;

public class LaunchAD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayDeque ad=new ArrayDeque();
		ad.add(100);
		ad.add("Telusko");
		ad.add(300);
		System.out.println(ad);
		ad.addFirst(1000);
		ad.addLast(2000);
		System.out.println(ad);
		
		

	}

}
