package com.example.todolist.services.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.example.todolist.services.exceptions.DateTimeUtil.formatInstant;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(ToDoNotFoundException.class)
    public ResponseEntity<StandardError> handleToDoNotFoundException(ToDoNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        String timestamp = DateTimeUtil.formatInstant(Instant.now());
        StandardError err = new StandardError(timestamp, status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        String error = "JSON em formato inválido!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String timestamp = DateTimeUtil.formatInstant(Instant.now());
        StandardError err = new StandardError(timestamp, status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ToDoInvalidJsonException.class)
    public ResponseEntity<StandardError> handleToDoInvalidJsonException(ToDoInvalidJsonException e, HttpServletRequest request) {
        String error = "JSON em formato inválido!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String timestamp = DateTimeUtil.formatInstant(Instant.now());
        StandardError err = new StandardError(timestamp, status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ToDoInvalidDateException.class)
    public ResponseEntity<StandardError> handleToDoInvalidDateException(ToDoInvalidDateException e, HttpServletRequest request) {
        String error = "Datas informadas inválidas!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String timestamp = DateTimeUtil.formatInstant(Instant.now());
        StandardError err = new StandardError(timestamp, status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
