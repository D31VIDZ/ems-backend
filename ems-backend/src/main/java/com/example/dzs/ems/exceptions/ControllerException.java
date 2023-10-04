package com.example.dzs.ems.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dzs.ems.dots.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerException{
	
	@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity threatDuplication(DataIntegrityViolationException ecveption) {
		
		ExceptionDTO newException = new ExceptionDTO("Ususario ja cadastrado", "400");
		return ResponseEntity.badRequest().body(newException);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threatNotFound(EntityNotFoundException ecxeption) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity GeneralException(Exception exception) {
	
	ExceptionDTO newException = new ExceptionDTO(exception.getMessage() , "500");
	return ResponseEntity.internalServerError().body(newException);
	}
}