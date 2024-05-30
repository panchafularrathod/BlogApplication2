package com.mock.BlogApplication.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	public UserNotFoundException() {
		super("user not found");
	}

}
