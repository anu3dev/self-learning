package com.telusko.learning;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class LaunchVec 
{

	public static void main(String[] args) 
	{
		Vector v=new Vector();
		v.add(10);
		v.add(20);
		v.add(30);
		v.add(40);
		
		System.out.println(v);
		
		Iterator itr=v.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("**********************************************");
		
		Enumeration en=v.elements();
		
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
		
		

	}

}
