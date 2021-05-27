package com.aula.microservico.crud.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestControllerAdvice
public class CrudExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handlerBedResquestException(Exception ex, WebRequest request) {
		return new ResponseEntity<ExceptionResponse>(
				new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

}
