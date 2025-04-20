package com.telusko.learning;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LaunchMapCom 
{

	public static void main(String[] args) 
	{
		//HashMap<Integer, String> map1=new HashMap<>();
		
		HashMap map1=new HashMap();
		
		map1.put(1, "Virat");
		map1.put(2, "Virat");
		map1.put(3, "Rohan");
		
		System.out.println(map1);
		Collection col=map1.values();
		Iterator itr1=col.iterator();
		
		while(itr1.hasNext())
		{
			//System.out.println(itr1.next());
			String str1=(String) itr1.next();
			System.out.println(str1.toUpperCase());
		}
		
		Set set=map1.keySet();
		
		Iterator itr2=set.iterator();
		while(itr2.hasNext())
		{
//			System.out.println(itr2.next());
			Integer i=(Integer) itr2.next();
			System.out.println("Key is : "+ i);
		}
		
		Set set2=map1.entrySet();
		
		Iterator itr3=set2.iterator();
		while(itr3.hasNext())
		{
			Map.Entry pair=(Entry) itr3.next();
			System.out.println(pair.getKey() + " : " +pair.getValue());
		}
		

	}

}
