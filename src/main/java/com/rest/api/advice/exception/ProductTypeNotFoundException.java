package com.rest.api.advice.exception;

public class ProductTypeNotFoundException extends RuntimeException {
	public ProductTypeNotFoundException() {
		super();
	}
	
	public ProductTypeNotFoundException(String msg) {
		super(msg);
	}
	
	public ProductTypeNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}
}
