package com.anu3dev.exception;

@SuppressWarnings("serial")
public class TouristNotFoundException extends RuntimeException {

	public TouristNotFoundException(String message){
		super(message);
	}
}
