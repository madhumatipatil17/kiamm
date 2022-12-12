package com.materialmanagement.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception exception) {
		ExceptionResponce response = new ExceptionResponce(LocalDateTime.now(), false, exception.getMessage(), null);
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { GlobalException.class })
	public ResponseEntity<Object> handleGlobalException(GlobalException exception) {
		ExceptionResponce response = new ExceptionResponce(LocalDateTime.now(), false, exception.getMessage(), null);
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
		ExceptionResponce response = new ExceptionResponce(LocalDateTime.now(), false, exception.getMessage(), null);
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { MaxUploadSizeExceededException.class })
	public ResponseEntity<Object> handleMaxSizeFileUploadException(MaxUploadSizeExceededException exception) {
		ExceptionResponce response = new ExceptionResponce(LocalDateTime.now(), false, "Maximum Uplaod Size is 500kb",
				null);
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException exception, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
//		String fieldError= exception.getBindingResult().getFieldError().getDefaultMessage();
//		ExceptionResponce response=new ExceptionResponce(LocalDateTime.now(),false,fieldError);
		Map<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fielName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fielName, message);
		});
		ExceptionResponce response = new ExceptionResponce(LocalDateTime.now(), false, "Validation Error!!", errors);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
		
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolationException(
	    ConstraintViolationException ex, WebRequest request) {
	    //log.error(INVALID_REQUEST, ex);
	    Map<String, Object> errors = new HashMap<>();
	    if (!ex.getConstraintViolations().isEmpty()) {
	        for (ConstraintViolation constraintViolation : ex.getConstraintViolations()) {
	            String fieldName = null;
	            for (Node node : constraintViolation.getPropertyPath()) {
	                fieldName = node.getName();
	            }
	            errors.put("message", constraintViolation.getMessage());
	        }
	    }
	    ExceptionResponce response = new ExceptionResponce(LocalDateTime.now(), false, "Validation Error!!", errors);
	    return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	

}
