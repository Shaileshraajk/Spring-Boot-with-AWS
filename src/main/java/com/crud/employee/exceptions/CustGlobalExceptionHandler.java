package com.crud.employee.exceptions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	Logger logger = LoggerFactory.getLogger(CustGlobalExceptionHandler.class);
	
	 @ExceptionHandler(EmployeeNameNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNameNotFoundException(Exception ex){
		
		ErrorResponse err = new ErrorResponse();
        err.setTimestamp(LocalDateTime.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        logger.error("Error", ex);
        
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}
	 
	 
	 @ExceptionHandler(EmpIdNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleEmpIdNotFoundException(Exception ex){
			
			ErrorResponse err = new ErrorResponse();
	        err.setTimestamp(LocalDateTime.now());
	        err.setStatus(HttpStatus.BAD_REQUEST.value());
	        err.setMessage(ex.getMessage());
	        logger.error("Error", ex);
	        
	        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
			
		}
	 
	
	
	

}
