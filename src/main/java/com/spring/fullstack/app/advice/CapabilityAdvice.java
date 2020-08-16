package com.spring.fullstack.app.advice;

import java.util.HashMap;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.fullstack.app.exception.CapabilityException;
import com.spring.fullstack.app.exception.CapabilityNotFoundResponse;

@ControllerAdvice
public class CapabilityAdvice {

	@ResponseBody
	@ExceptionHandler(CapabilityException.class)
	public final ResponseEntity<CapabilityNotFoundResponse> handle(CapabilityException ex){
		System.out.println(ex.getMessage());
		CapabilityNotFoundResponse response = new CapabilityNotFoundResponse(ex.getMessage());
		return new ResponseEntity<CapabilityNotFoundResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<?> handleInputErrors(ConstraintViolationException e) {
		var errorMap = new HashMap<String, String>();

		for(ConstraintViolation<?> err : e.getConstraintViolations()) {
			errorMap.put(err.getPropertyPath().toString(), err.getMessage());
		}

		return ResponseEntity.badRequest().body(errorMap);
	}
}
