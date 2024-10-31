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
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorMessage> handleResourceNotFoundException(
      ResourceNotFoundException ex) {
    ErrorMessage errorMessage =
        new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), "Resource Not Found");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }

  @ExceptionHandler(value = NoResourceFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorMessage> handleNoResourceFoundException(NoResourceFoundException ex) {
    ErrorMessage errorMessage =
        new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            new Date(),
            ex.getMessage(),
            "Resource Not Found on path " + "/" + ex.getResourcePath());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
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
