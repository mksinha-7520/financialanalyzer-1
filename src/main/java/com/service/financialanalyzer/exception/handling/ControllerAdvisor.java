package com.service.financialanalyzer.exception.handling;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {


	        return new ResponseEntity<>("Searched Customer Not Found.", HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(PaymentCannotBeNegative.class)
	    public ResponseEntity<Object> handlePaymentCannotBeNegative(PaymentCannotBeNegative ex) {


	        return new ResponseEntity<>("Insufficient Balance.", HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 @ExceptionHandler(PaymentNotAllowed.class)
	    public ResponseEntity<Object> handlePaymentNotAllowed(PaymentNotAllowed ex) {


	        return new ResponseEntity<>("Payment Not Allowed.", HttpStatus.BAD_REQUEST);
	    }
	

}
