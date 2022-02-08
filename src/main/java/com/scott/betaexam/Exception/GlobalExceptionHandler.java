package com.scott.betaexam.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> employeeNotFoundException(Exception ex, WebRequest request){
        ErrorResponse response=new ErrorResponse(LocalDateTime.now(),"Customer Not " +
                "Found ", request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        FieldError error = ex.getFieldError();
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(error.getField(), error.getDefaultMessage());
        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), "Validation Feild", errorMap.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
