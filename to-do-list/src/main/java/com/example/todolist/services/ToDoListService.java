package com.example.todolist.services;

import com.example.todolist.entities.ToDoList;
import com.example.todolist.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public List<ToDoList> findAll() {
        return toDoListRepository.findAll();
    }

    public List<ToDoList> findById(Long id) {
        Optional<ToDoList> idFound = toDoListRepository.findById(id);
        return (List<ToDoList>) idFound.get();
    }

    public ToDoList insert(ToDoList obj) {
        return toDoListRepository.save(obj);
    }

    public void deleteById(Long id) {
        toDoListRepository.deleteById(id);
    }

    public void update(Long id, ToDoList todo) {
        toDoListRepository.save(todo);
    }
}
