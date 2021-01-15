package com.alvesjefs.zuulmerce.resources;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alvesjefs.zuulmerce.resources.exceptions.StandardError;
import com.alvesjefs.zuulmerce.services.exceptions.NameNotFoundException;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<StandardError> notFoundName(NameNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimesTemp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Resource Not Found!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
