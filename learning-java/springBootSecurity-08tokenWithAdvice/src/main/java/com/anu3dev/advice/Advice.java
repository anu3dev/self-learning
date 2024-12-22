package com.anu3dev.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.core.AuthenticationException;

import com.anu3dev.model.APIErrorDetails;

@RestControllerAdvice
public class Advice {
	@ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<APIErrorDetails> handleAuthenticationException(AuthenticationException ex) {
		APIErrorDetails details = new APIErrorDetails(LocalDateTime.now(), "UNAUTHORIZED_ERROR", ex.getMessage());
        return new ResponseEntity<APIErrorDetails>(details, HttpStatus.UNAUTHORIZED);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<APIErrorDetails> handleAllProblem(Exception ex){
		System.out.println(ex);
		APIErrorDetails details = new APIErrorDetails(LocalDateTime.now(), "NOT_FOUND_ERROR", ex.getMessage());
    	return new ResponseEntity<APIErrorDetails>(details, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
