package com.sb.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sb.error.ErrorDetails;
import com.sb.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorControllerAdvice 
{
	@ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException te)
    {
		System.out.println("Control is TouristExceptionhandler method");
    	ErrorDetails details = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "404-Found");
    	return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllProblem(Exception te)
    {
		System.out.println("Control is Handle other problems ");
    	ErrorDetails details = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "404-Found");
    	return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
