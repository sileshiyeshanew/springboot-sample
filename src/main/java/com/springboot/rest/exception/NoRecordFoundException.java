package com.springboot.rest.exception;

public class NoRecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NoRecordFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoRecordFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoRecordFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoRecordFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoRecordFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
