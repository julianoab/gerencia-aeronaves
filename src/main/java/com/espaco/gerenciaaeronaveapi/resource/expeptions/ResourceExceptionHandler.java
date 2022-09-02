package com.espaco.gerenciaaeronaveapi.resource.expeptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.espaco.gerenciaaeronaveapi.service.exceptions.EntidadeNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<StandardError> entidadeNaoEncontrada(EntidadeNaoEncontradaException expetion, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(expetion.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
