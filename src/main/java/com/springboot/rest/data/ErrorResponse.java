package com.springboot.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse {
	private String errorCode;
	private String errorDecs;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDecs() {
		return errorDecs;
	}
	public void setErrorDecs(String errorDecs) {
		this.errorDecs = errorDecs;
	}
	

}
