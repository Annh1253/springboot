package com.example.demo.error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(Exception notFoundException, WebRequest request){
        List<String> messageList = new ArrayList<>();
        messageList.add(notFoundException.getMessage());
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, messageList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> messageList = new ArrayList<>();
        for(FieldError error : ex.getFieldErrors()){
            messageList.add(error.getDefaultMessage());
        }
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, messageList);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
