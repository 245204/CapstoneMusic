package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends Exception{
	
	@ExceptionHandler(NoAlbumFoundException.class)
	
	public ResponseEntity<?> handleserror(NoAlbumFoundException noa){
		Error error=new Error(HttpStatus.NOT_FOUND, noa.getMessage());
		return new  ResponseEntity(error,HttpStatus.NOT_FOUND);
		
}

}
