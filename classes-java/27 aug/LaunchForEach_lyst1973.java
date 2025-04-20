package com.telusko.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
//
//class ALpha implements Consumer
//{
//
//	@Override
//	public void accept(Object arg0) {
//		
//		
//	}
//	
//}


public class LaunchForEach 
{

	public static void main(String[] args) 
	{
		ArrayList list=new ArrayList();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(50);
		//System.out.println(list);
		
		List list2=Arrays.asList(10,20,30,40);
		//System.out.println(list);
		
//		for(Object obj:list2)
//		{
//			System.out.println(obj);
//		}
		
//		Consumer con=new Consumer()
//				{
//					public void accept(Object obj)
//					{
//						System.out.println(obj);
//						
//					}
//				};
//		
//		Consumer con=n->System.out.println(n);
//			
//		
//		
//		list2.forEach(con);
		
		list2.forEach(n->System.out.println(n));

	}

}
