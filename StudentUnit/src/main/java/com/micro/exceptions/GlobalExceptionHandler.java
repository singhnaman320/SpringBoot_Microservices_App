package com.micro.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// For Customizing our error body as a response if any error occurs then we make little changes
	// WebRequest req--->To print Description
		
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(StudentNotFoundException bnf, WebRequest req){
			
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
			
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
		
	// For exception if no uri found with given name--> some properties also added to application.properties
		
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CustomizeError> notFoundUri(NoHandlerFoundException nhf, WebRequest req){
			
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), nhf.getMessage(), req.getDescription(false));
			
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
		
		
	//To handle any generic type of exception, if occurs
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomizeError> anyGenericException(Exception e, WebRequest req){
			
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
			
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
		
	// Handling the validation exception
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomizeError> validationErr(MethodArgumentNotValidException me){
			
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), "Validation Error", me.getBindingResult().getFieldError().getDefaultMessage());
			
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);

	}
}
