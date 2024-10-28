package com.telusko.profiles.beans;

public class JUnit implements Courses 
{
	@Override
	public boolean courseRegistered() 
	{
		System.out.println("JUnit5 course purchased!");
		return true;
	}
}


