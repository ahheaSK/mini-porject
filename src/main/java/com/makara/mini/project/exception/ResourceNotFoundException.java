package com.makara.mini.project.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiExecption{

	public ResourceNotFoundException(String resourceName, Long id) {
		super(HttpStatus.NOT_FOUND, "%s With id = %d not found".formatted(resourceName, id));
		// TODO Auto-generated constructor stub
	}

}
