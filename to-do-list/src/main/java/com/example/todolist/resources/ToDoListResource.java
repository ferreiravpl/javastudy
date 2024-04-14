package com.example.todolist.resources;


import com.example.todolist.entities.ToDoList;
import com.example.todolist.services.ToDoListService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/todo")
@RestController
public class ToDoListResource {

    @Autowired
    private ToDoListService toDoListService;

    public ToDoListResource(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public ResponseEntity<List<ToDoList>> findAll() {

        List<ToDoList> toDoList = toDoListService.findAll();
        return ResponseEntity.ok().body(toDoList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ToDoList todo = toDoListService.findById(id);
        return ResponseEntity.ok().body(todo);
    }

    @JsonFormat
    @PostMapping
    public ResponseEntity<?> createToDo(@RequestBody ToDoList todo) {
        todo = toDoListService.insert(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        toDoListService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody ToDoList todo) {
        ToDoList updatedTodo = toDoListService.update(id, todo);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTodo);
    }

}
