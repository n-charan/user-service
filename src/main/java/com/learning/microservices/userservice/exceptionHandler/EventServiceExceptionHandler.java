package com.learning.microservices.userservice.exceptionHandler;

import com.learning.microservices.userservice.exception.ResourceNotFoundException;
import com.learning.microservices.userservice.model.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class EventServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),
                "500", "Exception occurred", exception.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),
                "404", "Resource Not Found", exception.getMessage());

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),
                "400", "Validation Failed", details.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
