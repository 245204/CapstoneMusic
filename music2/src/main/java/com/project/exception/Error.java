package com.project.exception;

import org.springframework.http.HttpStatus;

public class Error {
	private HttpStatus status;
	private String message;

	public Error() {
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
