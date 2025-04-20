package com.telusko.learning;

//interface Gener<T>
//{
//	}

class Gen<T> 
{
	T ref;
	
	public Gen(T ref)
	{
		this.ref=ref;
		
	}
	
	public void disp()
	{
		System.out.println("Type of Gen is "+ ref.getClass().getName());
	}
	
	public T getRef()
	{
		return ref;
	}
	
}

public class LaunchGen3 {

	public static void main(String[] args) 
	{
		Gen<Integer> gen=new Gen<>(10);
		gen.disp();
		System.out.println(gen.getRef());
		

	}

}
