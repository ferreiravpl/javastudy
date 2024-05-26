package com.example.todolist.services;

import com.example.todolist.entities.ToDoList;
import com.example.todolist.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public List<ToDoList> findAll() {
        return toDoListRepository.findAll();
    }

    public ToDoList findById(Long id) {
        return toDoListRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ToDo com o ID " + id + " não encontrado."));
    }

    public ToDoList insert(ToDoList obj) {
           return toDoListRepository.save(obj);
    }

    public void deleteById(Long id) {
        if (!toDoListRepository.existsById(id)) {
            throw new NoSuchElementException("ToDo com o ID " + id + " não encontrado.");
        }
        toDoListRepository.deleteById(id);
    }

    public ToDoList update(Long id, ToDoList updatedToDo) {
        ToDoList currentToDo = findById(id);
        updateToDoDetails(currentToDo, updatedToDo);
        return toDoListRepository.save(currentToDo);
    }

    public void updateToDoDetails(ToDoList currentToDo, ToDoList updatedToDo) {
        currentToDo.setDescription(updatedToDo.getDescription());
        currentToDo.setInitialDate(updatedToDo.getInitialDate());
        currentToDo.setFinalDate(updatedToDo.getFinalDate());
        currentToDo.setIsDone(updatedToDo.getIsDone());
    }

}
