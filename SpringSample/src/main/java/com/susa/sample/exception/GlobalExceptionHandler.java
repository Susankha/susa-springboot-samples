package com.susa.sample.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleResourceNotFoundException(ResourceNotFoundException ex) {

    return new ErrorMessage(
        HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), "Resource Not Found");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, WebRequest request) {
    List<String> errors =
        ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
    Map<String, List<String>> errorResponse = new LinkedHashMap<>();
    errorResponse.put("errors", errors);
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
