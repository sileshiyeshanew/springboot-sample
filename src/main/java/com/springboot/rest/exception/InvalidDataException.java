package com.springboot.rest.exception;

public class InvalidDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public InvalidDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	

}
