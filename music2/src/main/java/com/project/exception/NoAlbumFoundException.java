package com.project.exception;

public class NoAlbumFoundException extends RuntimeException {
	
	public NoAlbumFoundException(String message) {
		super(message);
	}
}
