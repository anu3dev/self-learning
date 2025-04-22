package com.telusko.learning;

import java.util.ArrayList;

public class LaunchGen {

	public static void main(String[] args) 
	{
		//typesafety
//		String []ar=new String[5];
//		ar[0]="Telusko";
//		ar[1]="Navin Reddy";
//		//ar[2]=10;
//		
//		String str1=ar[0];
//		System.out.println(str1.toUpperCase());
//		String str2=ar[1];
//		System.out.println(str2.toUpperCase());
		
		//no type safety
		ArrayList<String> list=new ArrayList<String>();
		list.add("Telusko");
		list.add("Navin reddy");
		//list.add(10);
		
		
//		
//		String str1=(String) list.get(0);
//		System.out.println(str1.toUpperCase());
//		String str2=(String) list.get(1);
//		System.out.println(str2.toUpperCase());
		
		String str1=list.get(0);
		System.out.println(str1.length());
		

	}

}
