package com.example.todolist.services.exceptions;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class ToDoInvalidJsonException extends HttpMessageNotReadableException {

    public ToDoInvalidJsonException(String msg) {
        super(msg);
    }
}
