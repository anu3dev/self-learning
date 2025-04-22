package com.telusko.learning;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
class Animal
{
	int age;
	String behavior;
	
}


public class LaunchMap1 {

	public static void main(String[] args) 
	{
		HashMap map1=new HashMap();
		map1.put(1, "Virat");//key value pair is one Entry
		map1.put(2, "Virat");
		map1.put(null, "Rohan");//null as key is allowed with HashMap
		System.out.println(map1);
		
		Animal a=new Animal();
		
		map1.put(a, "People with no focus");
		map1.put(44, a);
		
		map1.put("Telusko", "Navin");
		System.out.println(map1);
		
		LinkedHashMap map2=new LinkedHashMap();
		map2.put(4, "Virat");//key value pair is one Entry
		map2.put(2, "Virat");
		map2.put(1, "Rohan");
		System.out.println(map2);
		
		TreeMap tm=new TreeMap();
		tm.put(4, "Virat");//key value pair is one Entry
		tm.put(2, "Virat");
		tm.put(1, "Rohan");
		System.out.println(tm);
		
		
		
//		Hashtable ht=new Hashtable();
//		//ht.put(null, "Hyder"); null is not allowed with hashtable
//		ht.put(2, "Abbas");
//		System.out.println(ht);

	}

}
