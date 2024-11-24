package com.anu3dev.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anu3dev.exception.TouristNotFoundException;
import com.anu3dev.model.ErrorDetails;

@RestControllerAdvice
public class TouristErrorControllerAdvice {
	@ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException te){
    	ErrorDetails details = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "404-Found");
    	return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllProblems(Exception te){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "500 Internal Server Error");
    	return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
