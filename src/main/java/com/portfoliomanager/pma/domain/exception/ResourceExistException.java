package com.portfoliomanager.pma.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value= HttpStatus.ALREADY_REPORTED)
public class ResourceExistException extends RuntimeException{
	
	private static final long serialVersionUID =1L;
	
	public ResourceExistException() {
		super();
	}

	public ResourceExistException(String messsage) {
		
		 super(messsage);
		
	}
	
	

}
