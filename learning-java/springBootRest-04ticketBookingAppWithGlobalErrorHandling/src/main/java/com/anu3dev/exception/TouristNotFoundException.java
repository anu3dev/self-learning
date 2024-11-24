package com.anu3dev.exception;

public class TouristNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5832328155170065617L;
	public TouristNotFoundException(String message){
		super(message);
	}
}
