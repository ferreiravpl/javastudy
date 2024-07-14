package com.example.todolist.services.exceptions;

public class ToDoInvalidDateException extends RuntimeException{

    public ToDoInvalidDateException(String msg) {
        super(msg);
    }

}
