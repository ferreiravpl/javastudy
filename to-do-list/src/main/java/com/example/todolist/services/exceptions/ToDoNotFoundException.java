package com.example.todolist.services.exceptions;

import java.util.NoSuchElementException;

public class ToDoNotFoundException extends NoSuchElementException {

    public ToDoNotFoundException(String msg) {
        super(msg);
    }

}
